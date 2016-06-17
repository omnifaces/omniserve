/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:doctype.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlDoctype")
public class HtmlDoctypeRenderer extends BaseRenderer {

    /**
     * Encode.
     *
     * @param context the context.
     * @param component the component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        ResponseWriter writer = context.getResponseWriter();
        String publicId = (String) getAttribute(context, component, "public", "");
        if (publicId.length() > 0) {
            publicId = " PUBLIC \"" + publicId + "\"";
        }
        String system = (String) getAttribute(context, component, "system", "");
        if (system.length() > 0) {
            system = " \"" + system + "\"";
        }
        writer.writeText("<!DOCTYPE html" + publicId + system + ">");
    }
}
