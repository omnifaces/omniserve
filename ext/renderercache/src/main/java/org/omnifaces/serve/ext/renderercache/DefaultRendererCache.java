/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.renderercache;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import org.omnifaces.serve.renderkit.Renderer;

/**
 * The default renderer cache.
 */
@ApplicationScoped
@Default
public class DefaultRendererCache implements RendererCache {

    /**
     * Stores the cache size constant.
     */
    private static final int CACHE_SIZE = 25;

    /**
     * Stores the cached processors.
     */
    private final transient Map<String, Renderer> renderers;

    /**
     * Constructor.
     */
    public DefaultRendererCache() {
        renderers = Collections.synchronizedMap(new LinkedHashMap<String, Renderer>() {
            private static final long serialVersionUID = 8300976593414373625L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Renderer> eldest) {
                return size() > CACHE_SIZE;
            }

        });
    }

    /**
     * Get the renderer.
     *
     * @param renderKitId the render kit id.
     * @param componentFamily the component family.
     * @param rendererType the renderer type.
     * @return the renderer, or null if not found.
     */
    @Override
    public Renderer get(String renderKitId, String componentFamily, String rendererType) {
        return renderers.get(renderKitId + "#" + componentFamily + "#" + rendererType);
    }

    /**
     * Put the renderer.
     *
     * @param renderKitId the render kit id.
     * @param componentFamily the component family.
     * @param rendererType the renderer type.
     * @param renderer the renderer.
     */
    @Override
    public void put(String renderKitId, String componentFamily, String rendererType, Renderer renderer) {
        renderers.put(renderKitId + "#" + componentFamily + "#" + rendererType, renderer);
    }
}
