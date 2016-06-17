/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.event;

/**
 * An event.
 */
public class Event {

    /**
     * Stores the source.
     */
    private final Object source;

    /**
     * Constructor.
     *
     * @param source the UI component.
     */
    public Event(Object source) {
        this.source = source;
    }

    /**
     * Get the source.
     *
     * @return the source.
     */
    public Object getSource() {
        return source;
    }
}
