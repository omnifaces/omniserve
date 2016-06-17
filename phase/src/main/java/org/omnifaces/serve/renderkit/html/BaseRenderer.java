/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.util.Iterator;
import java.util.Map;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.Renderer;
import org.omnifaces.serve.renderkit.ResponseWriter;

/**
 * A simple base renderer.
 */
abstract class BaseRenderer implements Renderer<PhaseContext, UIComponent> {

    /**
     * Decode.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void decode(PhaseContext context, UIComponent component) {
        Iterator<UIComponent> children = component.getChildren().iterator();
        while (children.hasNext()) {
            UIComponent child = children.next();
            Renderer renderer = context.getRenderKit().getRenderer(child.getFamily(), child.getRendererType());
            renderer.decode(context, child);
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
        Iterator<UIComponent> children = component.getChildren().iterator();
        while (children.hasNext()) {
            UIComponent child = children.next();
            Renderer renderer = context.getRenderKit().getRenderer(child.getFamily(), child.getRendererType());
            renderer.encode(context, child);
        }
    }

    /**
     * Render the pass-through attributes.
     *
     * @param writer the writer.
     * @param component the component.
     */
    protected void encodePassthroughAttributes(ResponseWriter writer, UIComponent component) {
        Map<String, Object> passThroughAttributes = component.getPassThroughAttributes();
        passThroughAttributes.entrySet().stream().forEach((entry) -> {
            String name = entry.getKey();
            Object value = entry.getValue();
            encodeURIAttribute(writer, name, value.toString());
        });
    }

    /**
     * Render an attribute.
     *
     * @param writer the writer.
     * @param name the attribute.
     * @param value the value.
     */
    protected void encodeAttribute(ResponseWriter writer, String name, String value) {
        if (value != null) {
            writer.writeAttribute(name, value);
        }
    }

    /**
     * Render a URI attribute.
     *
     * @param writer the writer.
     * @param name the attribute.
     * @param value the value.
     */
    protected void encodeURIAttribute(ResponseWriter writer, String name, String value) {
        if (value != null) {
            writer.writeURIAttribute(name, value);
        }
    }

    /**
     * Get the attribute value.
     *
     * @param context the context.
     * @param component the UI component.
     * @param name the attribute name.
     * @return the value, or null if not found.
     */
    protected Object getAttribute(Context context, UIComponent component, String name) {
        Object result;
        if (component.getValueExpression(name) != null) {
            result = component.getValueExpression(name).getValue(context.getELContext());
        } else {
            result = component.getAttributes().get(name);
        }
        return result;
    }

    /**
     * Get the attribute value.
     *
     * @param context the context.
     * @param component the UI component.
     * @param name the attribute name.
     * @param defaultValue the default value.
     * @return the value, or the default value if not found.
     */
    protected Object getAttribute(Context context, UIComponent component, String name, Object defaultValue) {
        Object result = getAttribute(context, component, name);
        if (result == null) {
            result = defaultValue;
        }
        return result;
    }
}
