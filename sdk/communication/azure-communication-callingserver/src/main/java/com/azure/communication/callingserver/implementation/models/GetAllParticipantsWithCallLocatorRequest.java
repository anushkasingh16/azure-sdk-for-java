// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callingserver.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The request payload for get all participants. */
@Fluent
public final class GetAllParticipantsWithCallLocatorRequest {
    /*
     * The call locator.
     */
    @JsonProperty(value = "callLocator", required = true)
    private CallLocatorModel callLocator;

    /**
     * Get the callLocator property: The call locator.
     *
     * @return the callLocator value.
     */
    public CallLocatorModel getCallLocator() {
        return this.callLocator;
    }

    /**
     * Set the callLocator property: The call locator.
     *
     * @param callLocator the callLocator value to set.
     * @return the GetAllParticipantsWithCallLocatorRequest object itself.
     */
    public GetAllParticipantsWithCallLocatorRequest setCallLocator(CallLocatorModel callLocator) {
        this.callLocator = callLocator;
        return this;
    }
}