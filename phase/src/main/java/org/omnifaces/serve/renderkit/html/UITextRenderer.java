/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIText;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for text.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component",
        rendererType = "org.omnifaces.serve.component.UIText")
public class UITextRenderer extends BaseRenderer {

    /**
     * Encode the component.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        UIText text = (UIText) component;
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.write(text.getText());
    }
}
