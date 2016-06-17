/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit;

import javax.enterprise.util.AnnotationLiteral;

/**
 * The annotation literal for @ServeRenderKitId.
 */
@SuppressWarnings("all")
public class ServeRenderKitIdLiteral extends AnnotationLiteral<ServeRenderKitId> implements ServeRenderKitId {

    /**
     * Stores the serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Stores the render kit id.
     */
    private final String id;

    /**
     * Constructor.
     *
     * @param id the render kit id.
     */
    public ServeRenderKitIdLiteral(String id) {
        this.id = id;
    }

    /**
     * Get the render kit id.
     *
     * @return the render kit id.
     */
    @Override
    public String value() {
        return id;
    }
}
