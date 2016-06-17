/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.util.Iterator;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.Renderer;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:body.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlBody")
public class HtmlBodyRenderer extends BaseRenderer {

    /**
     * Encode.
     *
     * @param context the context.
     * @param component the component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("body");
        encodeAttribute(writer, "id", (String) getAttribute(context, component, "id"));
        Iterator<UIComponent> children = component.getChildren().iterator();
        while (children.hasNext()) {
            UIComponent child = children.next();
            Renderer renderer = context.getRenderKit().getRenderer(child.getFamily(), child.getRendererType());
            renderer.encode(context, child);
        }
        writer.endElement("body");
    }
}
