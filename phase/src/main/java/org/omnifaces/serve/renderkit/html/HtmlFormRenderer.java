/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlForm;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:form.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlForm")
public class HtmlFormRenderer extends BaseRenderer {

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
        if (id != null) {
            Map<String, String[]> requestParameterMap = request.getParameterMap();
            HtmlForm form = (HtmlForm) component;

            if (requestParameterMap.containsKey(id)) {
                form.setSubmitted(true);
            } else {
                form.setSubmitted(false);
            }
        }

        super.decode(context, component);
    }

    /**
     * Encode the begin.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        boolean rendered = (boolean) getAttribute(context, component, "rendered", Boolean.TRUE);
        if (rendered) {
            ResponseWriter writer = context.getResponseWriter();
            String id = (String) component.getValueExpression("id").getValue(context.getELContext());
            writer.startElement("form");
            writer.writeAttribute("id", id);
            String encType = (String) getAttribute(context, component, "enctype", "");
            if (!encType.equals("")) {
                writer.writeAttribute("enctype", encType);
            }
            writer.writeAttribute("name", id);
            writer.writeAttribute("method", "post");
            writer.writeAttribute("action", request.getRequestURI());
            encodeAttribute(writer, "class", (String) getAttribute(context, component, "styleClass"));
            encodeAttribute(writer, "accept-charset", (String) getAttribute(context, component, "acceptcharset"));
            writer.startElement("input");
            writer.writeAttribute("type", "hidden");
            writer.writeAttribute("name", id);
            writer.writeAttribute("value", id);
            writer.endElement("input");
            writer.startElement("input");
            writer.writeAttribute("type", "hidden");
            writer.writeAttribute("name", "org.omnifaces.serve.Postback");
            writer.writeAttribute("value", "true");
            writer.endElement("input");
            super.encode(context, component);
            writer.endElement("form");
        }
    }
}
