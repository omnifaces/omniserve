/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit;

import javax.inject.Inject;
import org.omnifaces.serve.cdi.CdiManager;

/**
 * The default render kit factory.
 */
public class DefaultRenderKitFactory implements RenderKitFactory {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Get the default render kit id.
     *
     * @return the default render kit id.
     */
    @Override
    public String getDefaultRenderKitId() {
        return "HTML_BASIC";
    }

    /**
     * Get the render kit.
     *
     * @param renderKitId the render kit id.
     * @return the render kit.
     */
    @Override
    public RenderKit getRenderKit(String renderKitId) {
        return cdiManager.getInstance(RenderKit.class, new ServeRenderKitIdLiteral(renderKitId));
    }
}
