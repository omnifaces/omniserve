/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import org.omnifaces.serve.converter.Converter;

/**
 * An UI output.
 */
public class UIOutput extends UIComponentBase implements ValueHolder {

    /**
     * Stores the converter.
     */
    private Converter converter;

    /**
     * Get the converter.
     *
     * @return the converter.
     */
    @Override
    public Converter getConverter() {
        return converter;
    }

    /**
     * Get the family.
     *
     * @return the family.
     */
    @Override
    public String getFamily() {
        return "org.omnifaces.serve.component";
    }

    /**
     * Set the converter.
     *
     * @param converter the converter.
     */
    @Override
    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    /**
     * Get the local value.
     *
     * @return the local value.
     */
    @Override
    public Object getLocalValue() {
        return getAttributes().get("localValue");
    }

    /**
     * Get the value.
     *
     * @return the value.
     */
    @Override
    public Object getValue() {
        return getAttributes().get("value");
    }

    /**
     * Is the local value set.
     *
     * @return true if it is, false otherwise.
     */
    @Override
    public boolean isLocalValueSet() {
        boolean result = false;
        if (getAttributes().containsKey("localValueSet")) {
            result = (boolean) getAttributes().get("localValueSet");
        }
        return result;
    }

    /**
     * Set the local value.
     *
     * @param localValue the local value.
     */
    @Override
    public void setLocalValue(Object localValue) {
        setLocalValueSet(true);
        if (localValue == null) {
            getAttributes().remove("localValue");
        } else {
            getAttributes().put("localValue", localValue);
        }
    }

    /**
     * Set the value.
     *
     * @param value the value.
     */
    public void setValue(Object value) {
        if (value == null) {
            getAttributes().remove("value");
        } else {
            getAttributes().put("value", value);
        }
    }

    /**
     * Set the local value set flag.
     *
     * @param localValueSet the local value set flag.
     */
    @Override
    public void setLocalValueSet(boolean localValueSet) {
        if (localValueSet) {
            getAttributes().put("localValueSet", localValueSet);
        } else {
            getAttributes().remove("localValueSet");
        }
    }
}
