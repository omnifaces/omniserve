/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import org.omnifaces.serve.converter.Converter;

/**
 * A value holder.
 */
public interface ValueHolder {

    /**
     * Get the converter.
     *
     * @return the converter.
     */
    Converter getConverter();

    /**
     * Get the local value.
     *
     * @return the local value.
     */
    Object getLocalValue();

    /**
     * Get the value.
     *
     * @return the value.
     */
    Object getValue();

    /**
     * Is the local value set.
     *
     * @return true if it is, false otherwise.
     */
    boolean isLocalValueSet();

    /**
     * Set the converter.
     *
     * @param converter the converter.
     */
    void setConverter(Converter converter);

    /**
     * Set the local value.
     *
     * @param localValue the local value.
     */
    void setLocalValue(Object localValue);

    /**
     * Set the local value set flag.
     *
     * @param localValueSet the local value set flag.
     */
    void setLocalValueSet(boolean localValueSet);
}
