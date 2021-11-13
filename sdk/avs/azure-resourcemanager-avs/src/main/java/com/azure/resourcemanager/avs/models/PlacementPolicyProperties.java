// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** Abstract placement policy properties. */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    defaultImpl = PlacementPolicyProperties.class)
@JsonTypeName("PlacementPolicyProperties")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "VmVm", value = VmPlacementPolicyProperties.class),
    @JsonSubTypes.Type(name = "VmHost", value = VmHostPlacementPolicyProperties.class)
})
@Fluent
public class PlacementPolicyProperties {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(PlacementPolicyProperties.class);

    /*
     * Whether the placement policy is enabled or disabled
     */
    @JsonProperty(value = "state")
    private PlacementPolicyState state;

    /*
     * Display name of the placement policy
     */
    @JsonProperty(value = "displayName")
    private String displayName;

    /*
     * The provisioning state
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private PlacementPolicyProvisioningState provisioningState;

    /**
     * Get the state property: Whether the placement policy is enabled or disabled.
     *
     * @return the state value.
     */
    public PlacementPolicyState state() {
        return this.state;
    }

    /**
     * Set the state property: Whether the placement policy is enabled or disabled.
     *
     * @param state the state value to set.
     * @return the PlacementPolicyProperties object itself.
     */
    public PlacementPolicyProperties withState(PlacementPolicyState state) {
        this.state = state;
        return this;
    }

    /**
     * Get the displayName property: Display name of the placement policy.
     *
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: Display name of the placement policy.
     *
     * @param displayName the displayName value to set.
     * @return the PlacementPolicyProperties object itself.
     */
    public PlacementPolicyProperties withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the provisioningState property: The provisioning state.
     *
     * @return the provisioningState value.
     */
    public PlacementPolicyProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}