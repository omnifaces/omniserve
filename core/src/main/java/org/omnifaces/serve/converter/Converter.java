/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.converter;

/**
 * A converter.
 *
 * @param <T> the type.
 */
public interface Converter<T> {

    /**
     * Get the object.
     *
     * @param string the string.
     * @return the object.
     */
    T getAsObject(String string);

    /**
     * Get the object as a string.
     *
     * @param object the object.
     * @return the string.
     */
    String getAsString(T object);
}
