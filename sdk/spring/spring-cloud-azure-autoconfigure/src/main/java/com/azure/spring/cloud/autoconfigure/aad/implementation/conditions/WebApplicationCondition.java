// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.autoconfigure.aad.implementation.conditions;

import com.azure.spring.cloud.autoconfigure.aad.core.AADApplicationType;
import com.azure.spring.cloud.autoconfigure.aad.properties.AADAuthenticationProperties;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

import java.util.Optional;

import static com.azure.spring.cloud.autoconfigure.aad.core.AADApplicationType.RESOURCE_SERVER;
import static com.azure.spring.cloud.autoconfigure.aad.core.AADApplicationType.RESOURCE_SERVER_WITH_OBO;

/**
 * Web application or all in scenario condition.
 */
public final class WebApplicationCondition extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConditionMessage.Builder message = ConditionMessage.forCondition("AAD Web Application Condition");
        AADAuthenticationProperties properties =
            Binder.get(context.getEnvironment())
                  .bind("spring.cloud.azure.active-directory", AADAuthenticationProperties.class)
                  .orElse(null);
        if (properties == null) {
            return ConditionOutcome.noMatch(message.notAvailable("aad authorization properties"));
        }

        if (!StringUtils.hasText(properties.getClientId())) {
            return ConditionOutcome.noMatch(message.didNotFind("client-id").atAll());
        }

        // Bind properties will not execute AADAuthenticationProperties#afterPropertiesSet()
        AADApplicationType applicationType = Optional.ofNullable(properties.getApplicationType())
                                                     .orElseGet(AADApplicationType::inferApplicationTypeByDependencies);
        if (applicationType == null
            || applicationType == RESOURCE_SERVER
            || applicationType == RESOURCE_SERVER_WITH_OBO) {
            return ConditionOutcome.noMatch(
                message.because("spring.cloud.azure.active-directory.application-type=" + applicationType));
        }
        return ConditionOutcome.match(
            message.foundExactly("spring.cloud.azure.active-directory.application-type=" + applicationType));
    }
}