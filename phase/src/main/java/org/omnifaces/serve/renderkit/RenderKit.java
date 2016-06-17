/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit;

import java.io.Writer;

/**
 * The render kit.
 */
public interface RenderKit {

    /**
     * Create the response writer.
     *
     * @param writer the underlying writer.
     * @param contentType the content type.
     * @param characterEncoding the character encoding.
     * @return the response writer.
     */
    ResponseWriter createResponseWriter(Writer writer, String contentType, String characterEncoding);

    /**
     * Get the render kit id.
     *
     * @return the render kit id.
     */
    String getRenderKitId();

    /**
     * Get the renderer.
     *
     * @param componentFamily the component family.
     * @param rendererType the renderer type.
     * @return the renderer.
     */
    Renderer getRenderer(String componentFamily, String rendererType);
}
