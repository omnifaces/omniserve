/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.event;

import org.omnifaces.serve.component.ValueHolder;

/**
 * A value change event.
 */
public class ValueChangeEvent extends Event {

    /**
     * Stores the new value.
     */
    private final Object newValue;

    /**
     * Stores the old value.
     */
    private final Object oldValue;

    /**
     * Constructor.
     *
     * @param valueHolder the value holder.
     * @param oldValue the old value.
     * @param newValue the new value.
     */
    public ValueChangeEvent(ValueHolder valueHolder, Object oldValue, Object newValue) {
        super(valueHolder);
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * Get the new value.
     *
     * @return the new value.
     */
    public Object getNewValue() {
        return newValue;
    }

    /**
     * Get the old value.
     *
     * @return the old value.
     */
    public Object getOldValue() {
        return oldValue;
    }
}
