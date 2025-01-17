// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonProperty;

/** SasPolicy assigned to the storage account. */
@Fluent
public final class SasPolicy {
    /*
     * The SAS expiration period, DD.HH:MM:SS.
     */
    @JsonProperty(value = "sasExpirationPeriod", required = true)
    private String sasExpirationPeriod;

    /*
     * The SAS expiration action. Can only be Log.
     */
    @JsonProperty(value = "expirationAction", required = true)
    private ExpirationAction expirationAction;

    /**
     * Get the sasExpirationPeriod property: The SAS expiration period, DD.HH:MM:SS.
     *
     * @return the sasExpirationPeriod value.
     */
    public String sasExpirationPeriod() {
        return this.sasExpirationPeriod;
    }

    /**
     * Set the sasExpirationPeriod property: The SAS expiration period, DD.HH:MM:SS.
     *
     * @param sasExpirationPeriod the sasExpirationPeriod value to set.
     * @return the SasPolicy object itself.
     */
    public SasPolicy withSasExpirationPeriod(String sasExpirationPeriod) {
        this.sasExpirationPeriod = sasExpirationPeriod;
        return this;
    }

    /**
     * Get the expirationAction property: The SAS expiration action. Can only be Log.
     *
     * @return the expirationAction value.
     */
    public ExpirationAction expirationAction() {
        return this.expirationAction;
    }

    /**
     * Set the expirationAction property: The SAS expiration action. Can only be Log.
     *
     * @param expirationAction the expirationAction value to set.
     * @return the SasPolicy object itself.
     */
    public SasPolicy withExpirationAction(ExpirationAction expirationAction) {
        this.expirationAction = expirationAction;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (sasExpirationPeriod() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property sasExpirationPeriod in model SasPolicy"));
        }
        if (expirationAction() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property expirationAction in model SasPolicy"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(SasPolicy.class);
}
