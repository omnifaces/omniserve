/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import java.util.Iterator;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.Renderer;

/**
 * A base renderer.
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
     * Get the attribute value.
     *
     * @param context the context.
     * @param component the UI component.
     * @param name the attribute name.
     * @return the value, or null if not found.
     */
    protected Object getAttribute(PhaseContext context, UIComponent component, String name) {
        Object result;
        if (component.getValueExpression(name) != null) {
            result = component.getValueExpression(name).getValue(context.getELContext());
        } else {
            result = component.getAttributes().get(name);
        }
        return result;
    }
}
