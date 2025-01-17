// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;
import java.util.Map;

/** AzureWorkload SQL-specific restore with integrated rehydration of recovery point. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType")
@JsonTypeName("AzureWorkloadSQLRestoreWithRehydrateRequest")
@Fluent
public final class AzureWorkloadSqlRestoreWithRehydrateRequest extends AzureWorkloadSqlRestoreRequest {
    /*
     * RP Rehydration Info
     */
    @JsonProperty(value = "recoveryPointRehydrationInfo")
    private RecoveryPointRehydrationInfo recoveryPointRehydrationInfo;

    /**
     * Get the recoveryPointRehydrationInfo property: RP Rehydration Info.
     *
     * @return the recoveryPointRehydrationInfo value.
     */
    public RecoveryPointRehydrationInfo recoveryPointRehydrationInfo() {
        return this.recoveryPointRehydrationInfo;
    }

    /**
     * Set the recoveryPointRehydrationInfo property: RP Rehydration Info.
     *
     * @param recoveryPointRehydrationInfo the recoveryPointRehydrationInfo value to set.
     * @return the AzureWorkloadSqlRestoreWithRehydrateRequest object itself.
     */
    public AzureWorkloadSqlRestoreWithRehydrateRequest withRecoveryPointRehydrationInfo(
        RecoveryPointRehydrationInfo recoveryPointRehydrationInfo) {
        this.recoveryPointRehydrationInfo = recoveryPointRehydrationInfo;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadSqlRestoreWithRehydrateRequest withShouldUseAlternateTargetLocation(
        Boolean shouldUseAlternateTargetLocation) {
        super.withShouldUseAlternateTargetLocation(shouldUseAlternateTargetLocation);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadSqlRestoreWithRehydrateRequest withIsNonRecoverable(Boolean isNonRecoverable) {
        super.withIsNonRecoverable(isNonRecoverable);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadSqlRestoreWithRehydrateRequest withAlternateDirectoryPaths(
        List<SqlDataDirectoryMapping> alternateDirectoryPaths) {
        super.withAlternateDirectoryPaths(alternateDirectoryPaths);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadSqlRestoreWithRehydrateRequest withRecoveryType(RecoveryType recoveryType) {
        super.withRecoveryType(recoveryType);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadSqlRestoreWithRehydrateRequest withSourceResourceId(String sourceResourceId) {
        super.withSourceResourceId(sourceResourceId);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadSqlRestoreWithRehydrateRequest withPropertyBag(Map<String, String> propertyBag) {
        super.withPropertyBag(propertyBag);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadSqlRestoreWithRehydrateRequest withTargetInfo(TargetRestoreInfo targetInfo) {
        super.withTargetInfo(targetInfo);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadSqlRestoreWithRehydrateRequest withRecoveryMode(RecoveryMode recoveryMode) {
        super.withRecoveryMode(recoveryMode);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadSqlRestoreWithRehydrateRequest withTargetVirtualMachineId(String targetVirtualMachineId) {
        super.withTargetVirtualMachineId(targetVirtualMachineId);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (recoveryPointRehydrationInfo() != null) {
            recoveryPointRehydrationInfo().validate();
        }
    }
}
