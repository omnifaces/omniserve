/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.renderercache;

import org.omnifaces.serve.renderkit.Renderer;

/**
 * A renderer cache.
 */
public interface RendererCache {

    /**
     * Get the renderer.
     *
     * @param renderKitId the render kit id.
     * @param componentFamily the component family.
     * @param rendererType the renderer type.
     * @return the renderer, or null if not found.
     */
    Renderer get(String renderKitId, String componentFamily, String rendererType);

    /**
     * Put the renderer.
     *
     * @param renderKitId the render kit id.
     * @param componentFamily the component family.
     * @param rendererType the renderer type.
     * @param renderer the renderer.
     */
    void put(String renderKitId, String componentFamily, String rendererType, Renderer renderer);
}
