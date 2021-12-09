// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callingserver.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The result details of calling operation. */
@Fluent
public final class CallingOperationResultDetailsInternal {
    /*
     * The result code associated with the operation.
     */
    @JsonProperty(value = "code", required = true)
    private int code;

    /*
     * The subcode that further classifies the result.
     */
    @JsonProperty(value = "subcode", required = true)
    private int subcode;

    /*
     * The message is a detail explanation of subcode.
     */
    @JsonProperty(value = "message")
    private String message;

    /**
     * Get the code property: The result code associated with the operation.
     *
     * @return the code value.
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Set the code property: The result code associated with the operation.
     *
     * @param code the code value to set.
     * @return the CallingOperationResultDetailsInternal object itself.
     */
    public CallingOperationResultDetailsInternal setCode(int code) {
        this.code = code;
        return this;
    }

    /**
     * Get the subcode property: The subcode that further classifies the result.
     *
     * @return the subcode value.
     */
    public int getSubcode() {
        return this.subcode;
    }

    /**
     * Set the subcode property: The subcode that further classifies the result.
     *
     * @param subcode the subcode value to set.
     * @return the CallingOperationResultDetailsInternal object itself.
     */
    public CallingOperationResultDetailsInternal setSubcode(int subcode) {
        this.subcode = subcode;
        return this;
    }

    /**
     * Get the message property: The message is a detail explanation of subcode.
     *
     * @return the message value.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Set the message property: The message is a detail explanation of subcode.
     *
     * @param message the message value to set.
     * @return the CallingOperationResultDetailsInternal object itself.
     */
    public CallingOperationResultDetailsInternal setMessage(String message) {
        this.message = message;
        return this;
    }
}