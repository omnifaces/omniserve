/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit;

import java.io.Writer;

/**
 * A RenderKit used for testing.
 */
@ServeRenderKitId("TEST")
public class TestRenderKit implements RenderKit {

    /**
     * Create the response writer.
     *
     * @param writer the writer.
     * @param contentType the content type.
     * @param characterEncoding the character encoding.
     * @return the response writer.
     */
    @Override
    public ResponseWriter createResponseWriter(Writer writer, String contentType, String characterEncoding) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get the renderer.
     *
     * @param componentFamily the component family.
     * @param rendererType the renderer type.
     * @return the renderer.
     */
    @Override
    public Renderer getRenderer(String componentFamily, String rendererType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get the render kit id.
     *
     * @return the render kit id.
     */
    @Override
    public String getRenderKitId() {
        return "TEST";
    }
}
