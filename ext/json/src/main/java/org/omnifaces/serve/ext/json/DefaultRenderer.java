/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.json;

import java.util.Iterator;
import java.util.Map.Entry;
import javax.el.ValueExpression;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.Renderer;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The default JSON renderer if we can't find a specific one.
 */
@ServeRenderer(renderKitId = "JSON",
        componentFamily = "org.omnifaces.serve.component",
        rendererType = "org.omnifaces.serve.component.DefaultRenderer")
public class DefaultRenderer implements Renderer<PhaseContext, UIComponent> {

    /**
     * Encode the component.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement("component");
        responseWriter.writeAttribute("className", component.getClass().getName());
        if (!component.getAttributes().isEmpty()) {
            responseWriter.write(",");
            responseWriter.startElement("attributes");
            Iterator<Entry<String, Object>> iterator = component.getAttributes().entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, Object> entry = iterator.next();
                String key = entry.getKey();
                Object value = "";
                if (entry.getValue() != null) {
                    value = entry.getValue();
                }
                if (value instanceof ValueExpression) {
                    ValueExpression valueExpression = (ValueExpression) value;
                    value = valueExpression.getValue(context.getELContext());
                }
                responseWriter.writeAttribute(key, value.toString());
                if (iterator.hasNext()) {
                    responseWriter.write(",");
                }
            }
            responseWriter.endElement("attributes");
        }
        if (component.getChildren().size() > 0) {
            responseWriter.write(", children: [");
            Iterator<UIComponent> children = component.getChildren().iterator();
            while (children.hasNext()) {
                UIComponent child = children.next();
                Renderer renderer = context.getRenderKit().getRenderer(child.getFamily(), child.getRendererType());
                renderer.encode(context, child);
                if (children.hasNext()) {
                    responseWriter.write(",");
                }
            }
            responseWriter.write("]\n");
        }
        responseWriter.endElement("component");
    }
}
