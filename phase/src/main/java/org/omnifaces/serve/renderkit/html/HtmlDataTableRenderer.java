/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.util.Iterator;
import java.util.List;
import javax.el.ValueExpression;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlDataTable;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.Renderer;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The renderer for h:dataTable.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlDataTable")
public class HtmlDataTableRenderer extends BaseRenderer {

    /**
     * Stores the HTTP servlet request.
     */
    @Inject
    private HttpServletRequest request;

    /**
     * Encode the component.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        ResponseWriter writer = context.getResponseWriter();
        HtmlDataTable dataTable = (HtmlDataTable) component;
        ValueExpression valueExpression = dataTable.getValueExpression("value");
        List<Object> values = dataTable.toList(valueExpression.getValue(context.getELContext()));
        String var = (String) getAttribute(context, component, "var");

        writer.startElement("table");
        writer.startElement("tbody");
        for (Object value : values) {
            writer.startElement("tr");
            request.setAttribute(var, value);
            Iterator<UIComponent> children = dataTable.getChildren().iterator();
            while (children.hasNext()) {
                UIComponent child = children.next();
                Renderer renderer = context.getRenderKit().getRenderer(child.getFamily(), child.getRendererType());
                renderer.encode(context, child);
            }
            request.removeAttribute(var);
            writer.endElement("tr");
        }
        writer.endElement("tbody");
        writer.endElement("table");
    }
}
