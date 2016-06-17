/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.util.List;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.phase.PhaseMessage;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:messages.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlMessages")
public class HtmlMessagesRenderer extends BaseRenderer {

    /**
     * Encode.
     *
     * @param context the context.
     * @param component the component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        ResponseWriter responseWriter = context.getResponseWriter();
        List<PhaseMessage> messages = context.getMessageList();
        if (messages != null) {
            for (PhaseMessage message : messages) {
                responseWriter.write(message.getSummary());
                responseWriter.startElement("br");
                responseWriter.endElement("br");
            }
        }
    }
}
