/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.validator;

import javax.enterprise.util.AnnotationLiteral;

/**
 * The annotation literal for @ServeValidator.
 */
@SuppressWarnings("all")
public class ServeValidatorLiteral extends AnnotationLiteral<ServeValidator> implements ServeValidator {

    /**
     * Defines the serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Stores the validator id.
     */
    private final String value;

    /**
     * Constructor.
     *
     * @param value the validator id.
     */
    public ServeValidatorLiteral(String value) {
        this.value = value;
    }

    /**
     * Get the converter id.
     *
     * @return the converter id.
     */
    @Override
    public String value() {
        return value;
    }
}
