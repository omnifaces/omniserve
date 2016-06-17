/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit;

import javax.enterprise.util.AnnotationLiteral;

/**
 * The annotation literal for @ServeRenderer.
 */
@SuppressWarnings("all")
public class ServeRendererLiteral extends AnnotationLiteral<ServeRenderer> implements ServeRenderer {

    /**
     * Stores the serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Stores the component family.
     */
    private final String componentFamily;

    /**
     * Stores the render kit id.
     */
    private final String renderKitId;

    /**
     * Stores the rendererType.
     */
    private final String rendererType;

    /**
     * Constructor.
     *
     * @param renderKitId the render kit id.
     * @param componentFamily the component family.
     * @param rendererType the renderer type.
     */
    public ServeRendererLiteral(String renderKitId, String componentFamily, String rendererType) {
        this.renderKitId = renderKitId;
        this.componentFamily = componentFamily;
        this.rendererType = rendererType;
    }

    /**
     * Get the render kit id.
     *
     * @return the render kit id.
     */
    @Override
    public String renderKitId() {
        return renderKitId;
    }

    /**
     * Get the renderer type.
     *
     * @return the renderer type.
     */
    @Override
    public String rendererType() {
        return rendererType;
    }

    /**
     * Get the component family.
     *
     * @return the component family.
     */
    @Override
    public String componentFamily() {
        return componentFamily;
    }
}
