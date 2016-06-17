/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.renderercache;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import org.omnifaces.serve.renderkit.RenderKit;
import org.omnifaces.serve.renderkit.Renderer;

/**
 * A decorator around a RenderKit for renderer caching.
 */
@Decorator
@Priority(1000)
public abstract class RenderKitDecorator implements RenderKit {

    /**
     * Inject the processor cache.
     */
    @Inject
    private RendererCache rendererCache;

    /**
     * Inject the delegate.
     */
    @Inject
    @Delegate
    @Any
    private RenderKit renderKit;

    /**
     * Get the renderer.
     *
     * @param componentFamily the component family.
     * @param rendererType the renderer type.
     * @return the renderer.
     */
    @Override
    public Renderer getRenderer(String componentFamily, String rendererType) {
        String renderKitId = renderKit.getRenderKitId();
        Renderer result = rendererCache.get(renderKitId, componentFamily, rendererType);
        if (result == null) {
            result = renderKit.getRenderer(componentFamily, rendererType);
            rendererCache.put(renderKitId, componentFamily, rendererType, result);
        }
        return result;
    }
}
