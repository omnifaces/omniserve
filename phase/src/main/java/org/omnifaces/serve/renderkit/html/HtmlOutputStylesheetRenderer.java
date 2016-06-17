/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.converter.Converter;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:outputStylesheet.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlOutputStylesheet")
public class HtmlOutputStylesheetRenderer extends BaseRenderer {

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

            writer.startElement("link");
            String href = request.getContextPath()
                    + (String) getAttribute(context, component, "name");
            encodeAttribute(writer, "href", href);
            encodeAttribute(writer, "rel", "stylesheet");

            Object value = getAttribute(context, component, "value");
            String valueString = "";
            Converter converter = (Converter) getAttribute(context, component, "converter");
            if (converter != null) {
                valueString = converter.getAsString(value);
            } else if (value != null) {
                valueString = value.toString();
            }
            writer.write(valueString);

            writer.endElement("link");
        }
    }
}
