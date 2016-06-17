/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.EditableValueHolder;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.Renderer;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:select.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlSelect")
public class HtmlSelectRenderer extends HtmlOutputTextRenderer {

    /**
     * Stores the HTTP servlet request.
     */
    @Inject
    private HttpServletRequest request;

    /**
     * Decode.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void decode(PhaseContext context, UIComponent component) {
        String id = (String) component.getValueExpression("id").getValue(context.getELContext());
        Map<String, String[]> requestParameterMap = request.getParameterMap();
        String value = requestParameterMap.get(id)[0];
        if (value != null) {
            EditableValueHolder evh = (EditableValueHolder) component;
            evh.setSubmittedValue(value);
        }
    }

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
            writer.startElement("select");
            encodeAttribute(writer, "id", (String) getAttribute(context, component, "id"));
            encodeAttribute(writer, "name", (String) getAttribute(context, component, "id"));

            Iterator<UIComponent> children = component.getChildren().iterator();
            while (children.hasNext()) {
                UIComponent child = children.next();
                Renderer renderer = context.getRenderKit().getRenderer(child.getFamily(), child.getRendererType());
                renderer.encode(context, child);
            }

            writer.endElement("select");
        }
    }
}
