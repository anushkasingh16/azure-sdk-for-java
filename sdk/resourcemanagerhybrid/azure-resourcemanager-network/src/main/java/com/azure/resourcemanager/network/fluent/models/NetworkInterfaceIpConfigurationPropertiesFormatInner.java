// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.network.models.ApplicationGatewayBackendAddressPool;
import com.azure.resourcemanager.network.models.IpAllocationMethod;
import com.azure.resourcemanager.network.models.IpVersion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Properties of IP configuration. */
@Fluent
public final class NetworkInterfaceIpConfigurationPropertiesFormatInner {
    @JsonIgnore
    private final ClientLogger logger = new ClientLogger(NetworkInterfaceIpConfigurationPropertiesFormatInner.class);

    /*
     * The reference to Virtual Network Taps.
     */
    @JsonProperty(value = "virtualNetworkTaps")
    private List<VirtualNetworkTapInner> virtualNetworkTaps;

    /*
     * The reference of ApplicationGatewayBackendAddressPool resource.
     */
    @JsonProperty(value = "applicationGatewayBackendAddressPools")
    private List<ApplicationGatewayBackendAddressPool> applicationGatewayBackendAddressPools;

    /*
     * The reference of LoadBalancerBackendAddressPool resource.
     */
    @JsonProperty(value = "loadBalancerBackendAddressPools")
    private List<BackendAddressPoolInner> loadBalancerBackendAddressPools;

    /*
     * A list of references of LoadBalancerInboundNatRules.
     */
    @JsonProperty(value = "loadBalancerInboundNatRules")
    private List<InboundNatRuleInner> loadBalancerInboundNatRules;

    /*
     * Private IP address of the IP configuration.
     */
    @JsonProperty(value = "privateIPAddress")
    private String privateIpAddress;

    /*
     * Defines how a private IP address is assigned. Possible values are:
     * 'Static' and 'Dynamic'.
     */
    @JsonProperty(value = "privateIPAllocationMethod")
    private IpAllocationMethod privateIpAllocationMethod;

    /*
     * Available from Api-Version 2016-03-30 onwards, it represents whether the
     * specific ipconfiguration is IPv4 or IPv6. Default is taken as IPv4.
     * Possible values are: 'IPv4' and 'IPv6'.
     */
    @JsonProperty(value = "privateIPAddressVersion")
    private IpVersion privateIpAddressVersion;

    /*
     * Subnet bound to the IP configuration.
     */
    @JsonProperty(value = "subnet")
    private SubnetInner subnet;

    /*
     * Gets whether this is a primary customer address on the network
     * interface.
     */
    @JsonProperty(value = "primary")
    private Boolean primary;

    /*
     * Public IP address bound to the IP configuration.
     */
    @JsonProperty(value = "publicIPAddress")
    private PublicIpAddressInner publicIpAddress;

    /*
     * Application security groups in which the IP configuration is included.
     */
    @JsonProperty(value = "applicationSecurityGroups")
    private List<ApplicationSecurityGroupInner> applicationSecurityGroups;

    /*
     * The provisioning state of the network interface IP configuration.
     * Possible values are: 'Updating', 'Deleting', and 'Failed'.
     */
    @JsonProperty(value = "provisioningState")
    private String provisioningState;

    /**
     * Get the virtualNetworkTaps property: The reference to Virtual Network Taps.
     *
     * @return the virtualNetworkTaps value.
     */
    public List<VirtualNetworkTapInner> virtualNetworkTaps() {
        return this.virtualNetworkTaps;
    }

    /**
     * Set the virtualNetworkTaps property: The reference to Virtual Network Taps.
     *
     * @param virtualNetworkTaps the virtualNetworkTaps value to set.
     * @return the NetworkInterfaceIpConfigurationPropertiesFormatInner object itself.
     */
    public NetworkInterfaceIpConfigurationPropertiesFormatInner withVirtualNetworkTaps(
        List<VirtualNetworkTapInner> virtualNetworkTaps) {
        this.virtualNetworkTaps = virtualNetworkTaps;
        return this;
    }

    /**
     * Get the applicationGatewayBackendAddressPools property: The reference of ApplicationGatewayBackendAddressPool
     * resource.
     *
     * @return the applicationGatewayBackendAddressPools value.
     */
    public List<ApplicationGatewayBackendAddressPool> applicationGatewayBackendAddressPools() {
        return this.applicationGatewayBackendAddressPools;
    }

    /**
     * Set the applicationGatewayBackendAddressPools property: The reference of ApplicationGatewayBackendAddressPool
     * resource.
     *
     * @param applicationGatewayBackendAddressPools the applicationGatewayBackendAddressPools value to set.
     * @return the NetworkInterfaceIpConfigurationPropertiesFormatInner object itself.
     */
    public NetworkInterfaceIpConfigurationPropertiesFormatInner withApplicationGatewayBackendAddressPools(
        List<ApplicationGatewayBackendAddressPool> applicationGatewayBackendAddressPools) {
        this.applicationGatewayBackendAddressPools = applicationGatewayBackendAddressPools;
        return this;
    }

    /**
     * Get the loadBalancerBackendAddressPools property: The reference of LoadBalancerBackendAddressPool resource.
     *
     * @return the loadBalancerBackendAddressPools value.
     */
    public List<BackendAddressPoolInner> loadBalancerBackendAddressPools() {
        return this.loadBalancerBackendAddressPools;
    }

    /**
     * Set the loadBalancerBackendAddressPools property: The reference of LoadBalancerBackendAddressPool resource.
     *
     * @param loadBalancerBackendAddressPools the loadBalancerBackendAddressPools value to set.
     * @return the NetworkInterfaceIpConfigurationPropertiesFormatInner object itself.
     */
    public NetworkInterfaceIpConfigurationPropertiesFormatInner withLoadBalancerBackendAddressPools(
        List<BackendAddressPoolInner> loadBalancerBackendAddressPools) {
        this.loadBalancerBackendAddressPools = loadBalancerBackendAddressPools;
        return this;
    }

    /**
     * Get the loadBalancerInboundNatRules property: A list of references of LoadBalancerInboundNatRules.
     *
     * @return the loadBalancerInboundNatRules value.
     */
    public List<InboundNatRuleInner> loadBalancerInboundNatRules() {
        return this.loadBalancerInboundNatRules;
    }

    /**
     * Set the loadBalancerInboundNatRules property: A list of references of LoadBalancerInboundNatRules.
     *
     * @param loadBalancerInboundNatRules the loadBalancerInboundNatRules value to set.
     * @return the NetworkInterfaceIpConfigurationPropertiesFormatInner object itself.
     */
    public NetworkInterfaceIpConfigurationPropertiesFormatInner withLoadBalancerInboundNatRules(
        List<InboundNatRuleInner> loadBalancerInboundNatRules) {
        this.loadBalancerInboundNatRules = loadBalancerInboundNatRules;
        return this;
    }

    /**
     * Get the privateIpAddress property: Private IP address of the IP configuration.
     *
     * @return the privateIpAddress value.
     */
    public String privateIpAddress() {
        return this.privateIpAddress;
    }

    /**
     * Set the privateIpAddress property: Private IP address of the IP configuration.
     *
     * @param privateIpAddress the privateIpAddress value to set.
     * @return the NetworkInterfaceIpConfigurationPropertiesFormatInner object itself.
     */
    public NetworkInterfaceIpConfigurationPropertiesFormatInner withPrivateIpAddress(String privateIpAddress) {
        this.privateIpAddress = privateIpAddress;
        return this;
    }

    /**
     * Get the privateIpAllocationMethod property: Defines how a private IP address is assigned. Possible values are:
     * 'Static' and 'Dynamic'.
     *
     * @return the privateIpAllocationMethod value.
     */
    public IpAllocationMethod privateIpAllocationMethod() {
        return this.privateIpAllocationMethod;
    }

    /**
     * Set the privateIpAllocationMethod property: Defines how a private IP address is assigned. Possible values are:
     * 'Static' and 'Dynamic'.
     *
     * @param privateIpAllocationMethod the privateIpAllocationMethod value to set.
     * @return the NetworkInterfaceIpConfigurationPropertiesFormatInner object itself.
     */
    public NetworkInterfaceIpConfigurationPropertiesFormatInner withPrivateIpAllocationMethod(
        IpAllocationMethod privateIpAllocationMethod) {
        this.privateIpAllocationMethod = privateIpAllocationMethod;
        return this;
    }

    /**
     * Get the privateIpAddressVersion property: Available from Api-Version 2016-03-30 onwards, it represents whether
     * the specific ipconfiguration is IPv4 or IPv6. Default is taken as IPv4. Possible values are: 'IPv4' and 'IPv6'.
     *
     * @return the privateIpAddressVersion value.
     */
    public IpVersion privateIpAddressVersion() {
        return this.privateIpAddressVersion;
    }

    /**
     * Set the privateIpAddressVersion property: Available from Api-Version 2016-03-30 onwards, it represents whether
     * the specific ipconfiguration is IPv4 or IPv6. Default is taken as IPv4. Possible values are: 'IPv4' and 'IPv6'.
     *
     * @param privateIpAddressVersion the privateIpAddressVersion value to set.
     * @return the NetworkInterfaceIpConfigurationPropertiesFormatInner object itself.
     */
    public NetworkInterfaceIpConfigurationPropertiesFormatInner withPrivateIpAddressVersion(
        IpVersion privateIpAddressVersion) {
        this.privateIpAddressVersion = privateIpAddressVersion;
        return this;
    }

    /**
     * Get the subnet property: Subnet bound to the IP configuration.
     *
     * @return the subnet value.
     */
    public SubnetInner subnet() {
        return this.subnet;
    }

    /**
     * Set the subnet property: Subnet bound to the IP configuration.
     *
     * @param subnet the subnet value to set.
     * @return the NetworkInterfaceIpConfigurationPropertiesFormatInner object itself.
     */
    public NetworkInterfaceIpConfigurationPropertiesFormatInner withSubnet(SubnetInner subnet) {
        this.subnet = subnet;
        return this;
    }

    /**
     * Get the primary property: Gets whether this is a primary customer address on the network interface.
     *
     * @return the primary value.
     */
    public Boolean primary() {
        return this.primary;
    }

    /**
     * Set the primary property: Gets whether this is a primary customer address on the network interface.
     *
     * @param primary the primary value to set.
     * @return the NetworkInterfaceIpConfigurationPropertiesFormatInner object itself.
     */
    public NetworkInterfaceIpConfigurationPropertiesFormatInner withPrimary(Boolean primary) {
        this.primary = primary;
        return this;
    }

    /**
     * Get the publicIpAddress property: Public IP address bound to the IP configuration.
     *
     * @return the publicIpAddress value.
     */
    public PublicIpAddressInner publicIpAddress() {
        return this.publicIpAddress;
    }

    /**
     * Set the publicIpAddress property: Public IP address bound to the IP configuration.
     *
     * @param publicIpAddress the publicIpAddress value to set.
     * @return the NetworkInterfaceIpConfigurationPropertiesFormatInner object itself.
     */
    public NetworkInterfaceIpConfigurationPropertiesFormatInner withPublicIpAddress(
        PublicIpAddressInner publicIpAddress) {
        this.publicIpAddress = publicIpAddress;
        return this;
    }

    /**
     * Get the applicationSecurityGroups property: Application security groups in which the IP configuration is
     * included.
     *
     * @return the applicationSecurityGroups value.
     */
    public List<ApplicationSecurityGroupInner> applicationSecurityGroups() {
        return this.applicationSecurityGroups;
    }

    /**
     * Set the applicationSecurityGroups property: Application security groups in which the IP configuration is
     * included.
     *
     * @param applicationSecurityGroups the applicationSecurityGroups value to set.
     * @return the NetworkInterfaceIpConfigurationPropertiesFormatInner object itself.
     */
    public NetworkInterfaceIpConfigurationPropertiesFormatInner withApplicationSecurityGroups(
        List<ApplicationSecurityGroupInner> applicationSecurityGroups) {
        this.applicationSecurityGroups = applicationSecurityGroups;
        return this;
    }

    /**
     * Get the provisioningState property: The provisioning state of the network interface IP configuration. Possible
     * values are: 'Updating', 'Deleting', and 'Failed'.
     *
     * @return the provisioningState value.
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Set the provisioningState property: The provisioning state of the network interface IP configuration. Possible
     * values are: 'Updating', 'Deleting', and 'Failed'.
     *
     * @param provisioningState the provisioningState value to set.
     * @return the NetworkInterfaceIpConfigurationPropertiesFormatInner object itself.
     */
    public NetworkInterfaceIpConfigurationPropertiesFormatInner withProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (virtualNetworkTaps() != null) {
            virtualNetworkTaps().forEach(e -> e.validate());
        }
        if (applicationGatewayBackendAddressPools() != null) {
            applicationGatewayBackendAddressPools().forEach(e -> e.validate());
        }
        if (loadBalancerBackendAddressPools() != null) {
            loadBalancerBackendAddressPools().forEach(e -> e.validate());
        }
        if (loadBalancerInboundNatRules() != null) {
            loadBalancerInboundNatRules().forEach(e -> e.validate());
        }
        if (subnet() != null) {
            subnet().validate();
        }
        if (publicIpAddress() != null) {
            publicIpAddress().validate();
        }
        if (applicationSecurityGroups() != null) {
            applicationSecurityGroups().forEach(e -> e.validate());
        }
    }
}