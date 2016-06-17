/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The default HTML renderer if we can't find a specific one.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component",
        rendererType = "org.omnifaces.serve.component.DefaultRenderer")
public class DefaultRenderer extends BaseRenderer {

    /**
     * Encode the component.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.write(" *** Unable to find renderer for component: " + component.getClass() + " *** ");
    }
}
