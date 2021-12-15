// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.applicationinsights.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Properties that contain a workbook for PATCH operation. */
@Fluent
public final class WorkbookPropertiesUpdateParameters {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(WorkbookPropertiesUpdateParameters.class);

    /*
     * The user-defined name (display name) of the workbook.
     */
    @JsonProperty(value = "displayName")
    private String displayName;

    /*
     * Configuration of this particular workbook. Configuration data is a
     * string containing valid JSON
     */
    @JsonProperty(value = "serializedData")
    private String serializedData;

    /*
     * Workbook category, as defined by the user at creation time.
     */
    @JsonProperty(value = "category")
    private String category;

    /*
     * A list of 0 or more tags that are associated with this workbook
     * definition
     */
    @JsonProperty(value = "tags")
    private List<String> tags;

    /*
     * The description of the workbook.
     */
    @JsonProperty(value = "description")
    private String description;

    /*
     * The unique revision id for this workbook definition
     */
    @JsonProperty(value = "revision")
    private String revision;

    /**
     * Get the displayName property: The user-defined name (display name) of the workbook.
     *
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: The user-defined name (display name) of the workbook.
     *
     * @param displayName the displayName value to set.
     * @return the WorkbookPropertiesUpdateParameters object itself.
     */
    public WorkbookPropertiesUpdateParameters withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the serializedData property: Configuration of this particular workbook. Configuration data is a string
     * containing valid JSON.
     *
     * @return the serializedData value.
     */
    public String serializedData() {
        return this.serializedData;
    }

    /**
     * Set the serializedData property: Configuration of this particular workbook. Configuration data is a string
     * containing valid JSON.
     *
     * @param serializedData the serializedData value to set.
     * @return the WorkbookPropertiesUpdateParameters object itself.
     */
    public WorkbookPropertiesUpdateParameters withSerializedData(String serializedData) {
        this.serializedData = serializedData;
        return this;
    }

    /**
     * Get the category property: Workbook category, as defined by the user at creation time.
     *
     * @return the category value.
     */
    public String category() {
        return this.category;
    }

    /**
     * Set the category property: Workbook category, as defined by the user at creation time.
     *
     * @param category the category value to set.
     * @return the WorkbookPropertiesUpdateParameters object itself.
     */
    public WorkbookPropertiesUpdateParameters withCategory(String category) {
        this.category = category;
        return this;
    }

    /**
     * Get the tags property: A list of 0 or more tags that are associated with this workbook definition.
     *
     * @return the tags value.
     */
    public List<String> tags() {
        return this.tags;
    }

    /**
     * Set the tags property: A list of 0 or more tags that are associated with this workbook definition.
     *
     * @param tags the tags value to set.
     * @return the WorkbookPropertiesUpdateParameters object itself.
     */
    public WorkbookPropertiesUpdateParameters withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the description property: The description of the workbook.
     *
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: The description of the workbook.
     *
     * @param description the description value to set.
     * @return the WorkbookPropertiesUpdateParameters object itself.
     */
    public WorkbookPropertiesUpdateParameters withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the revision property: The unique revision id for this workbook definition.
     *
     * @return the revision value.
     */
    public String revision() {
        return this.revision;
    }

    /**
     * Set the revision property: The unique revision id for this workbook definition.
     *
     * @param revision the revision value to set.
     * @return the WorkbookPropertiesUpdateParameters object itself.
     */
    public WorkbookPropertiesUpdateParameters withRevision(String revision) {
        this.revision = revision;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}