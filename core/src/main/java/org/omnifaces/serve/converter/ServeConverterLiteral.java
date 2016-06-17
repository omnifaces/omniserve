/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.converter;

import javax.enterprise.util.AnnotationLiteral;

/**
 * The annotation literal for @ServeConverter.
 */
@SuppressWarnings("all")
public class ServeConverterLiteral extends AnnotationLiteral<ServeConverter> implements ServeConverter {

    /**
     * Defines the serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Stores the converter id.
     */
    private final String value;

    /**
     * Stores the forClass.
     */
    private final Class forClass;

    /**
     * Constructor.
     *
     * @param value the converter id.
     * @param forClass the class type.
     */
    public ServeConverterLiteral(String value, Class forClass) {
        this.value = value;
        this.forClass = forClass;
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

    /**
     * Get the forClass value.
     *
     * @return the forClass value.
     */
    @Override
    public Class forClass() {
        return forClass;
    }
}
