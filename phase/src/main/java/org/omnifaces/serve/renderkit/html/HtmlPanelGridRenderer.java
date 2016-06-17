/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.util.Iterator;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlPanelGrid;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.Renderer;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The renderer for h:panelGrid.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlPanelGrid")
public class HtmlPanelGridRenderer extends BaseRenderer {

    /**
     * Encode the component.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        ResponseWriter writer = context.getResponseWriter();
        HtmlPanelGrid panelGrid = (HtmlPanelGrid) component;
        int columns = (int) getAttribute(context, component, "columns");

        writer.startElement("table");
        writer.startElement("tbody");
        writer.startElement("tr");
        int columnIndex = 0;
        Iterator<UIComponent> children = panelGrid.getChildren().iterator();
        while (children.hasNext()) {
            UIComponent child = children.next();
            writer.startElement("td");
            Renderer renderer = context.getRenderKit().getRenderer(child.getFamily(), child.getRendererType());
            renderer.encode(context, child);
            writer.endElement("td");
            columnIndex++;
            if (columnIndex == columns) {
                writer.endElement("tr");
                writer.startElement("tr");
                columnIndex = 0;
            }
        }
        writer.endElement("tr");
        writer.endElement("tbody");
        writer.endElement("table");
    }
}
