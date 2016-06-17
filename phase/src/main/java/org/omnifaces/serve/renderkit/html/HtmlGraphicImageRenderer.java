/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:graphicImage.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlGraphicImage")
public class HtmlGraphicImageRenderer extends BaseRenderer {

    /**
     * Stores the HTTP servlet request.
     */
    @Inject
    private HttpServletRequest request;

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

            writer.startElement("img");
            String href = request.getContextPath()
                    + (String) getAttribute(context, component, "value");
            encodeAttribute(writer, "src", href);

            writer.endElement("img");
        }
    }
}
