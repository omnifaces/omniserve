/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import java.util.Iterator;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.Renderer;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The renderer for UIComposite.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.ext.composite",
        rendererType = "org.omnifaces.serve.ext.composite.UICompositeComponent")
public class UICompositeComponentRenderer implements Renderer<PhaseContext, UIComponent> {

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
}
