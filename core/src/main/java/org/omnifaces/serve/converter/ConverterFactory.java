/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.converter;

/**
 * The factory for converters.
 */
public interface ConverterFactory {

    /**
     * Create the converter.
     *
     * @param converterId the converter id.
     * @return the converter, or null if not found.
     */
    Converter createConverter(String converterId);

    /**
     * Create the converter for the give expected type.
     *
     * @param expectedType the expected type.
     * @return the converter, or null if not found.
     */
    Converter createConverter(Class<?> expectedType);
}
