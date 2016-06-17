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
 * The HTML renderer for h:panelGroup.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlPanelGroup")
public class HtmlPanelGroupRenderer extends BaseRenderer {

    /**
     * Encode.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        boolean rendered = (boolean) getAttribute(context, component, "rendered", Boolean.TRUE);
        if (rendered) {
            ResponseWriter writer = context.getResponseWriter();
            String layout = (String) getAttribute(context, component, "layout", "span");

            if (layout.equals("block")) {
                layout = "div";
            }

            writer.startElement(layout);
            encodeAttribute(writer, "id", (String) getAttribute(context, component, "id"));
            encodeAttribute(writer, "class", (String) getAttribute(context, component, "styleClass"));
            encodeAttribute(writer, "style", (String) getAttribute(context, component, "style"));
            encodePassthroughAttributes(writer, component);

            Iterator<UIComponent> children = component.getChildren().iterator();
            while (children.hasNext()) {
                UIComponent child = children.next();
                Renderer renderer = context.getRenderKit().getRenderer(child.getFamily(), child.getRendererType());
                renderer.encode(context, child);
            }

            writer.endElement(layout);
        }
    }
}
