/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit;

/**
 * The render kit factory.
 */
public interface RenderKitFactory {

    /**
     * Get the default render kit id.
     *
     * @return the default render kit id.
     */
    String getDefaultRenderKitId();

    /**
     * Get the render kit.
     *
     * @param renderKitId the render kit id.
     * @return the render kit.
     */
    RenderKit getRenderKit(String renderKitId);
}
