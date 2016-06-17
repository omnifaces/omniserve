/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.EditableValueHolder;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:inputCheckbox.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlInputCheckbox")
public class HtmlInputCheckboxRenderer extends HtmlOutputTextRenderer {

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
        Map<String, String[]> requestParameterMap = request.getParameterMap();
        String value = requestParameterMap.get(id)[0];
        if (value != null && (value.equalsIgnoreCase("on")
                || value.equalsIgnoreCase("yes")
                || value.equalsIgnoreCase("true"))) {
            EditableValueHolder evh = (EditableValueHolder) component;
            evh.setSubmittedValue(true);
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
            encodeAttribute(writer, "type", "checkbox");
            boolean value = (boolean) getAttribute(context, component, "value");
            if (value) {
                encodeAttribute(writer, "checked", "checked");
            }
            writer.endElement("input");
        }
    }
}
