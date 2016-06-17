/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.lifecycle;

import javax.enterprise.util.AnnotationLiteral;

/**
 * The annotation literal for @LifecycleId.
 */
@SuppressWarnings("all")
public class LifecycleIdLiteral extends AnnotationLiteral<LifecycleId> implements LifecycleId {

    /**
     * Stores the serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Stores the lifecycle id.
     */
    private final String id;

    /**
     * Constructor.
     *
     * @param id the lifecycle id.
     */
    public LifecycleIdLiteral(String id) {
        this.id = id;
    }

    /**
     * Get the lifecycle id.
     *
     * @return the lifecycle id.
     */
    @Override
    public String value() {
        return id;
    }
}
