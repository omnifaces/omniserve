/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.io.Writer;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import org.omnifaces.serve.cdi.CdiManager;
import org.omnifaces.serve.renderkit.RenderKit;
import org.omnifaces.serve.renderkit.Renderer;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderKitId;
import org.omnifaces.serve.renderkit.ServeRendererLiteral;

/**
 * A HTML RenderKit.
 */
@ApplicationScoped
@Default
@ServeRenderKitId("HTML_BASIC")
public class HtmlRenderKit implements RenderKit {

    /**
     * Stores our id.
     */
    private static final String RENDER_KIT_ID = "HTML_BASIC";

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Create the response writer.
     *
     * @param writer the writer.
     * @param contentTypeList the list of candidate content types.
     * @param characterEncoding the requested character encoding.
     * @return the response writer.
     */
    @Override
    public ResponseWriter createResponseWriter(Writer writer, String contentTypeList, String characterEncoding) {
        return new HtmlResponseWriter(writer);
    }

    /**
     * Get the renderer.
     *
     * @param componentFamily the component family.
     * @param rendererType the renderer type.
     * @return the renderer, or null if not found.
     */
    @Override
    public Renderer getRenderer(String componentFamily, String rendererType) {
        Renderer result;
        boolean exists = cdiManager.exists(Object.class,
                new ServeRendererLiteral(RENDER_KIT_ID, componentFamily, rendererType));
        if (exists) {
            result = (Renderer) cdiManager.getInstance(Object.class,
                    new ServeRendererLiteral(RENDER_KIT_ID, componentFamily, rendererType));
        } else {
            result = (Renderer) cdiManager.getInstance(Object.class,
                    new ServeRendererLiteral(RENDER_KIT_ID,
                            "org.omnifaces.serve.component",
                            "org.omnifaces.serve.component.DefaultRenderer"));
        }
        return result;
    }

    /**
     * Get the render kit id.
     *
     * @return the render kit id.
     */
    @Override
    public String getRenderKitId() {
        return RENDER_KIT_ID;
    }
}
