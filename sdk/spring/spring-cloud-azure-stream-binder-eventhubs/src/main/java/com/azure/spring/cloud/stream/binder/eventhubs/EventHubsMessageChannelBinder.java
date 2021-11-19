// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.stream.binder.eventhubs;

import com.azure.messaging.eventhubs.CheckpointStore;
import com.azure.spring.cloud.stream.binder.eventhubs.properties.EventHubsConsumerProperties;
import com.azure.spring.cloud.stream.binder.eventhubs.properties.EventHubsExtendedBindingProperties;
import com.azure.spring.cloud.stream.binder.eventhubs.properties.EventHubsProducerProperties;
import com.azure.spring.cloud.stream.binder.eventhubs.provisioning.EventHubsChannelProvisioner;
import com.azure.spring.eventhubs.core.EventHubsProcessorContainer;
import com.azure.spring.eventhubs.core.EventHubsTemplate;
import com.azure.spring.eventhubs.core.processor.DefaultEventHubsNamespaceProcessorFactory;
import com.azure.spring.eventhubs.core.producer.DefaultEventHubsNamespaceProducerFactory;
import com.azure.spring.eventhubs.core.properties.NamespaceProperties;
import com.azure.spring.eventhubs.core.properties.ProcessorProperties;
import com.azure.spring.eventhubs.core.properties.ProducerProperties;
import com.azure.spring.integration.eventhubs.inbound.EventHubsInboundChannelAdapter;
import com.azure.spring.integration.handler.DefaultMessageHandler;
import com.azure.spring.messaging.ListenerMode;
import com.azure.spring.messaging.PropertiesSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.binder.AbstractMessageChannelBinder;
import org.springframework.cloud.stream.binder.BinderHeaders;
import org.springframework.cloud.stream.binder.BinderSpecificPropertiesProvider;
import org.springframework.cloud.stream.binder.ExtendedConsumerProperties;
import org.springframework.cloud.stream.binder.ExtendedProducerProperties;
import org.springframework.cloud.stream.binder.ExtendedPropertiesBinder;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.cloud.stream.provisioning.ProducerDestination;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.expression.FunctionExpression;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class EventHubsMessageChannelBinder extends
    // @formatter:off
    AbstractMessageChannelBinder<ExtendedConsumerProperties<EventHubsConsumerProperties>, ExtendedProducerProperties<EventHubsProducerProperties>, EventHubsChannelProvisioner>
    // @formatter:on
    implements
    ExtendedPropertiesBinder<MessageChannel, EventHubsConsumerProperties, EventHubsProducerProperties> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventHubsMessageChannelBinder.class);
    private static final ExpressionParser EXPRESSION_PARSER = new SpelExpressionParser();

    private NamespaceProperties namespaceProperties;
    private EventHubsTemplate eventHubsTemplate;
    private CheckpointStore checkpointStore;
    private EventHubsProcessorContainer processorContainer;
    private EventHubsExtendedBindingProperties bindingProperties = new EventHubsExtendedBindingProperties();
    private final Map<String, ExtendedProducerProperties<EventHubsProducerProperties>>
        extendedProducerPropertiesMap = new ConcurrentHashMap<>();
    private final Map<Tuple2<String, String>, ExtendedConsumerProperties<EventHubsConsumerProperties>>
        extendedConsumerPropertiesMap = new ConcurrentHashMap<>();

    private final Map<String, EventHubInformation> eventHubsInUse = new ConcurrentHashMap<>();

    public EventHubsMessageChannelBinder(String[] headersToEmbed, EventHubsChannelProvisioner provisioningProvider) {
        super(headersToEmbed, provisioningProvider);
    }

    @Override
    protected MessageHandler createProducerMessageHandler(
        ProducerDestination destination,
        ExtendedProducerProperties<EventHubsProducerProperties> producerProperties,
        MessageChannel errorChannel) {
        extendedProducerPropertiesMap.put(destination.getName(), producerProperties);
        Assert.notNull(getEventHubTemplate(), "eventHubsTemplate can't be null when create a producer");

        eventHubsInUse.put(destination.getName(), new EventHubInformation(null));

        DefaultMessageHandler handler = new DefaultMessageHandler(destination.getName(), this.eventHubsTemplate);

        handler.setBeanFactory(getBeanFactory());
        handler.setSync(producerProperties.getExtension().isSync());
        handler.setSendTimeout(producerProperties.getExtension().getSendTimeout());
        handler.setSendFailureChannel(errorChannel);

        if (producerProperties.isPartitioned()) {
            handler.setPartitionIdExpression(
                EXPRESSION_PARSER.parseExpression("headers['" + BinderHeaders.PARTITION_HEADER + "']"));
        } else {
            handler.setPartitionKeyExpression(new FunctionExpression<Message<?>>(m -> m.getPayload().hashCode()));
        }
        return handler;
    }

    @Override
    protected MessageProducer createConsumerEndpoint(ConsumerDestination destination, String group,
                                                     ExtendedConsumerProperties<EventHubsConsumerProperties> properties) {
        extendedConsumerPropertiesMap.put(Tuples.of(destination.getName(), group), properties);
        Assert.notNull(getProcessorContainer(), "eventProcessorsContainer can't be null when create a consumer");

        eventHubsInUse.put(destination.getName(), new EventHubInformation(group));

        boolean anonymous = !StringUtils.hasText(group);
        if (anonymous) {
            group = "anonymous." + UUID.randomUUID();
        }

        EventHubsInboundChannelAdapter inboundAdapter;
        if (properties.isBatchMode()) {
            inboundAdapter = new EventHubsInboundChannelAdapter(this.processorContainer,
                destination.getName(), group, ListenerMode.BATCH, properties.getExtension().getCheckpoint());
        } else {
            inboundAdapter = new EventHubsInboundChannelAdapter(this.processorContainer,
                destination.getName(), group, properties.getExtension().getCheckpoint());
        }
        inboundAdapter.setBeanFactory(getBeanFactory());

        ErrorInfrastructure errorInfrastructure = registerErrorInfrastructure(destination, group, properties);
        inboundAdapter.setErrorChannel(errorInfrastructure.getErrorChannel());

        return inboundAdapter;
    }

    @Override
    public EventHubsConsumerProperties getExtendedConsumerProperties(String destination) {
        return this.bindingProperties.getExtendedConsumerProperties(destination);
    }

    @Override
    public EventHubsProducerProperties getExtendedProducerProperties(String destination) {
        return this.bindingProperties.getExtendedProducerProperties(destination);
    }

    @Override
    public String getDefaultsPrefix() {
        return this.bindingProperties.getDefaultsPrefix();
    }

    @Override
    public Class<? extends BinderSpecificPropertiesProvider> getExtendedPropertiesEntryClass() {
        return this.bindingProperties.getExtendedPropertiesEntryClass();
    }

    public void setBindingProperties(EventHubsExtendedBindingProperties bindingProperties) {
        this.bindingProperties = bindingProperties;
    }

    Map<String, EventHubInformation> getEventHubsInUse() {
        return eventHubsInUse;
    }

    static class EventHubInformation {

        private final String consumerGroup;

        EventHubInformation(String consumerGroup) {
            this.consumerGroup = consumerGroup;
        }

        public String getConsumerGroup() {
            return consumerGroup;
        }
    }

    private PropertiesSupplier<String, ProducerProperties> getProducerPropertiesSupplier() {
        return key -> {
            if (this.extendedProducerPropertiesMap.containsKey(key)) {
                EventHubsProducerProperties producerProperties = this.extendedProducerPropertiesMap.get(key)
                    .getExtension();
                producerProperties.setEventHubName(key);
                return producerProperties;
            } else {
                LOGGER.debug("Can't find extended properties for {}", key);
                return null;
            }
        };
    }

    private PropertiesSupplier<Tuple2<String, String>, ProcessorProperties> getProcessorPropertiesSupplier() {
        return key -> {
            if (this.extendedConsumerPropertiesMap.containsKey(key)) {
                EventHubsConsumerProperties consumerProperties = this.extendedConsumerPropertiesMap.get(key)
                    .getExtension();
                consumerProperties.setEventHubName(key.getT1());
                consumerProperties.setConsumerGroup(key.getT2());
                return consumerProperties;
            } else {
                LOGGER.debug("Can't find extended properties for destination {}, group {}", key.getT1(), key.getT2());
                return null;
            }
        };
    }

    private EventHubsTemplate getEventHubTemplate() {
        if (this.eventHubsTemplate == null) {
            this.eventHubsTemplate = new EventHubsTemplate(new DefaultEventHubsNamespaceProducerFactory(this.namespaceProperties, getProducerPropertiesSupplier()));
        }
        return this.eventHubsTemplate;
    }

    private EventHubsProcessorContainer getProcessorContainer() {
        if (this.processorContainer == null) {
            this.processorContainer = new EventHubsProcessorContainer(new DefaultEventHubsNamespaceProcessorFactory(this.checkpointStore, this.namespaceProperties, getProcessorPropertiesSupplier()));
        }
        return this.processorContainer;
    }

    public void setNamespaceProperties(NamespaceProperties namespaceProperties) {
        this.namespaceProperties = namespaceProperties;
    }

    public void setCheckpointStore(CheckpointStore checkpointStore) {
        this.checkpointStore = checkpointStore;
    }
}