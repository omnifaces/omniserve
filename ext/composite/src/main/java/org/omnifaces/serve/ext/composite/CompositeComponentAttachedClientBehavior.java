/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

/**
 * A composite component attached client behavior.
 */
public class CompositeComponentAttachedClientBehavior extends CompositeComponentAttachedObject {

    /**
     * Stores the event name.
     */
    private final String eventName;

    /**
     * Constructor.
     *
     * @param attachedFor the attached for.
     * @param eventName the event name.
     * @param object the attached object.
     */
    public CompositeComponentAttachedClientBehavior(
            String attachedFor, String eventName, Object object) {
        super(attachedFor, object);
        this.eventName = eventName;
    }

    /**
     * Get the event name.
     *
     * @return the event name.
     */
    public String getEventName() {
        return eventName;
    }
}
