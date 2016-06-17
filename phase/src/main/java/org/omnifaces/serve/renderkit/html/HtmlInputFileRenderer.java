/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.omnifaces.serve.component.EditableValueHolder;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:outputText.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlInputFile")
public class HtmlInputFileRenderer extends HtmlOutputTextRenderer {

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
        try {
            String id = (String) component.getValueExpression("id").getValue(context.getELContext());
            Part part = request.getPart(id);
            EditableValueHolder evh = (EditableValueHolder) component;
            evh.setSubmittedValue(part);
        } catch (IOException | ServletException e) { // NOPMD
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
            writer.startElement("input");
            encodeAttribute(writer, "id", (String) getAttribute(context, component, "id"));
            encodeAttribute(writer, "name", (String) getAttribute(context, component, "id"));
            encodeAttribute(writer, "type", "file");
            encodeAttribute(writer, "value", "");
            writer.endElement("input");
        }
    }
}
