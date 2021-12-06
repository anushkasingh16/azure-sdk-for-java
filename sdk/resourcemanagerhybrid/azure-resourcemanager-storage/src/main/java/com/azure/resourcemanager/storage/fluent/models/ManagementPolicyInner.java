// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.storage.models.ManagementPolicySchema;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** The Get Storage Account ManagementPolicies operation response. */
@Fluent
public final class ManagementPolicyInner extends ProxyResource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ManagementPolicyInner.class);

    /*
     * Returns the Storage Account Data Policies Rules.
     */
    @JsonProperty(value = "properties")
    private ManagementPolicyProperties innerProperties;

    /**
     * Get the innerProperties property: Returns the Storage Account Data Policies Rules.
     *
     * @return the innerProperties value.
     */
    private ManagementPolicyProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the lastModifiedTime property: Returns the date and time the ManagementPolicies was last modified.
     *
     * @return the lastModifiedTime value.
     */
    public OffsetDateTime lastModifiedTime() {
        return this.innerProperties() == null ? null : this.innerProperties().lastModifiedTime();
    }

    /**
     * Get the policy property: The Storage Account ManagementPolicy, in JSON format. See more details in:
     * https://docs.microsoft.com/en-us/azure/storage/common/storage-lifecycle-managment-concepts.
     *
     * @return the policy value.
     */
    public ManagementPolicySchema policy() {
        return this.innerProperties() == null ? null : this.innerProperties().policy();
    }

    /**
     * Set the policy property: The Storage Account ManagementPolicy, in JSON format. See more details in:
     * https://docs.microsoft.com/en-us/azure/storage/common/storage-lifecycle-managment-concepts.
     *
     * @param policy the policy value to set.
     * @return the ManagementPolicyInner object itself.
     */
    public ManagementPolicyInner withPolicy(ManagementPolicySchema policy) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagementPolicyProperties();
        }
        this.innerProperties().withPolicy(policy);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}