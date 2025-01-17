// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.personalizer.implementation;

import com.azure.ai.personalizer.implementation.models.ErrorResponseException;
import com.azure.ai.personalizer.implementation.models.RankRequest;
import com.azure.ai.personalizer.implementation.models.RankResponse;
import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerAdapter;
import reactor.core.publisher.Mono;

/** Initializes a new instance of the PersonalizerClientV1Preview3 type. */
public final class PersonalizerClientV1Preview3Impl {
    /** The proxy service used to perform REST calls. */
    private final PersonalizerClientV1Preview3Service service;

    /** Supported Cognitive Services endpoint. */
    private final String endpoint;

    /**
     * Gets Supported Cognitive Services endpoint.
     *
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /** The HTTP pipeline to send requests through. */
    private final HttpPipeline httpPipeline;

    /**
     * Gets The HTTP pipeline to send requests through.
     *
     * @return the httpPipeline value.
     */
    public HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    /** The serializer to serialize an object into a string. */
    private final SerializerAdapter serializerAdapter;

    /**
     * Gets The serializer to serialize an object into a string.
     *
     * @return the serializerAdapter value.
     */
    public SerializerAdapter getSerializerAdapter() {
        return this.serializerAdapter;
    }

    /** The ServiceConfigurationsImpl object to access its operations. */
    private final ServiceConfigurationsImpl serviceConfigurations;

    /**
     * Gets the ServiceConfigurationsImpl object to access its operations.
     *
     * @return the ServiceConfigurationsImpl object.
     */
    public ServiceConfigurationsImpl getServiceConfigurations() {
        return this.serviceConfigurations;
    }

    /** The PoliciesImpl object to access its operations. */
    private final PoliciesImpl policies;

    /**
     * Gets the PoliciesImpl object to access its operations.
     *
     * @return the PoliciesImpl object.
     */
    public PoliciesImpl getPolicies() {
        return this.policies;
    }

    /** The EvaluationsImpl object to access its operations. */
    private final EvaluationsImpl evaluations;

    /**
     * Gets the EvaluationsImpl object to access its operations.
     *
     * @return the EvaluationsImpl object.
     */
    public EvaluationsImpl getEvaluations() {
        return this.evaluations;
    }

    /** The EventsImpl object to access its operations. */
    private final EventsImpl events;

    /**
     * Gets the EventsImpl object to access its operations.
     *
     * @return the EventsImpl object.
     */
    public EventsImpl getEvents() {
        return this.events;
    }

    /** The LogsImpl object to access its operations. */
    private final LogsImpl logs;

    /**
     * Gets the LogsImpl object to access its operations.
     *
     * @return the LogsImpl object.
     */
    public LogsImpl getLogs() {
        return this.logs;
    }

    /** The ModelsImpl object to access its operations. */
    private final ModelsImpl models;

    /**
     * Gets the ModelsImpl object to access its operations.
     *
     * @return the ModelsImpl object.
     */
    public ModelsImpl getModels() {
        return this.models;
    }

    /** The MultiSlotEventsImpl object to access its operations. */
    private final MultiSlotEventsImpl multiSlotEvents;

    /**
     * Gets the MultiSlotEventsImpl object to access its operations.
     *
     * @return the MultiSlotEventsImpl object.
     */
    public MultiSlotEventsImpl getMultiSlotEvents() {
        return this.multiSlotEvents;
    }

    /** The MultiSlotsImpl object to access its operations. */
    private final MultiSlotsImpl multiSlots;

    /**
     * Gets the MultiSlotsImpl object to access its operations.
     *
     * @return the MultiSlotsImpl object.
     */
    public MultiSlotsImpl getMultiSlots() {
        return this.multiSlots;
    }

    /**
     * Initializes an instance of PersonalizerClientV1Preview3 client.
     *
     * @param endpoint Supported Cognitive Services endpoint.
     */
    PersonalizerClientV1Preview3Impl(String endpoint) {
        this(
                new HttpPipelineBuilder()
                        .policies(new UserAgentPolicy(), new RetryPolicy(), new CookiePolicy())
                        .build(),
                JacksonAdapter.createDefaultSerializerAdapter(),
                endpoint);
    }

    /**
     * Initializes an instance of PersonalizerClientV1Preview3 client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param endpoint Supported Cognitive Services endpoint.
     */
    PersonalizerClientV1Preview3Impl(HttpPipeline httpPipeline, String endpoint) {
        this(httpPipeline, JacksonAdapter.createDefaultSerializerAdapter(), endpoint);
    }

    /**
     * Initializes an instance of PersonalizerClientV1Preview3 client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param serializerAdapter The serializer to serialize an object into a string.
     * @param endpoint Supported Cognitive Services endpoint.
     */
    PersonalizerClientV1Preview3Impl(HttpPipeline httpPipeline, SerializerAdapter serializerAdapter, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.serializerAdapter = serializerAdapter;
        this.endpoint = endpoint;
        this.serviceConfigurations = new ServiceConfigurationsImpl(this);
        this.policies = new PoliciesImpl(this);
        this.evaluations = new EvaluationsImpl(this);
        this.events = new EventsImpl(this);
        this.logs = new LogsImpl(this);
        this.models = new ModelsImpl(this);
        this.multiSlotEvents = new MultiSlotEventsImpl(this);
        this.multiSlots = new MultiSlotsImpl(this);
        this.service =
                RestProxy.create(
                        PersonalizerClientV1Preview3Service.class, this.httpPipeline, this.getSerializerAdapter());
    }

    /**
     * The interface defining all the services for PersonalizerClientV1Preview3 to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{Endpoint}/personalizer/v1.1-preview.3")
    @ServiceInterface(name = "PersonalizerClientV1")
    public interface PersonalizerClientV1Preview3Service {
        @Post("/rank")
        @ExpectedResponses({201})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<RankResponse>> rank(
                @HostParam("Endpoint") String endpoint,
                @BodyParam("application/json") RankRequest rankRequest,
                @HeaderParam("Accept") String accept,
                Context context);
    }

    /**
     * Submit a Personalizer rank request. Receives a context and a list of actions. Returns which of the provided
     * actions should be used by your application, in rewardActionId.
     *
     * @param rankRequest A Personalizer Rank request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return returns which action to use as rewardActionId, and additional information about each action as a result
     *     of a Rank request.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<RankResponse>> rankWithResponseAsync(RankRequest rankRequest) {
        final String accept = "application/json";
        return FluxUtil.withContext(context -> service.rank(this.getEndpoint(), rankRequest, accept, context));
    }

    /**
     * Submit a Personalizer rank request. Receives a context and a list of actions. Returns which of the provided
     * actions should be used by your application, in rewardActionId.
     *
     * @param rankRequest A Personalizer Rank request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return returns which action to use as rewardActionId, and additional information about each action as a result
     *     of a Rank request.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<RankResponse>> rankWithResponseAsync(RankRequest rankRequest, Context context) {
        final String accept = "application/json";
        return service.rank(this.getEndpoint(), rankRequest, accept, context);
    }

    /**
     * Submit a Personalizer rank request. Receives a context and a list of actions. Returns which of the provided
     * actions should be used by your application, in rewardActionId.
     *
     * @param rankRequest A Personalizer Rank request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return returns which action to use as rewardActionId, and additional information about each action as a result
     *     of a Rank request.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RankResponse> rankAsync(RankRequest rankRequest) {
        return rankWithResponseAsync(rankRequest)
                .flatMap(
                        (Response<RankResponse> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Submit a Personalizer rank request. Receives a context and a list of actions. Returns which of the provided
     * actions should be used by your application, in rewardActionId.
     *
     * @param rankRequest A Personalizer Rank request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return returns which action to use as rewardActionId, and additional information about each action as a result
     *     of a Rank request.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RankResponse> rankAsync(RankRequest rankRequest, Context context) {
        return rankWithResponseAsync(rankRequest, context)
                .flatMap(
                        (Response<RankResponse> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Submit a Personalizer rank request. Receives a context and a list of actions. Returns which of the provided
     * actions should be used by your application, in rewardActionId.
     *
     * @param rankRequest A Personalizer Rank request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return returns which action to use as rewardActionId, and additional information about each action as a result
     *     of a Rank request.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public RankResponse rank(RankRequest rankRequest) {
        return rankAsync(rankRequest).block();
    }

    /**
     * Submit a Personalizer rank request. Receives a context and a list of actions. Returns which of the provided
     * actions should be used by your application, in rewardActionId.
     *
     * @param rankRequest A Personalizer Rank request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return returns which action to use as rewardActionId, and additional information about each action as a result
     *     of a Rank request.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<RankResponse> rankWithResponse(RankRequest rankRequest, Context context) {
        return rankWithResponseAsync(rankRequest, context).block();
    }
}
