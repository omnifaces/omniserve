/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

/**
 * A composite component attached object.
 */
public class CompositeComponentAttachedObject {

    /**
     * Stores the for.
     */
    private final String attachedFor;

    /**
     * Stores the object.
     */
    private final Object object;

    /**
     * Constructor.
     *
     * @param attachedFor the attached for.
     * @param object the attached object.
     */
    public CompositeComponentAttachedObject(String attachedFor, Object object) {
        this.attachedFor = attachedFor;
        this.object = object;
    }

    /**
     * Get the attached object.
     *
     * @return the attached object.
     */
    public Object getObject() {
        return object;
    }

    /**
     * Get the for.
     *
     * @return the for.
     */
    public String getFor() {
        return attachedFor;
    }
}
