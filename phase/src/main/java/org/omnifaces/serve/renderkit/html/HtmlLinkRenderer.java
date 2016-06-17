/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.util.Iterator;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIParameter;
import org.omnifaces.serve.converter.Converter;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:link.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlLink")
public class HtmlLinkRenderer extends BaseRenderer {

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

            writer.startElement("a");

            StringBuilder requestParameters = new StringBuilder();
            Iterator<UIComponent> children = component.getChildren().iterator();
            while (children.hasNext()) {
                UIComponent child = children.next();
                if (child instanceof UIParameter) {
                    UIParameter parameter = (UIParameter) child;
                    String name = (String) getAttribute(context, parameter, "name");
                    String value = (String) getAttribute(context, parameter, "value");

                    if (requestParameters.length() == 0) {
                        requestParameters.append("?");
                    } else {
                        requestParameters.append("&");
                    }
                    requestParameters.append(name);
                    requestParameters.append("=");
                    requestParameters.append(value);
                }
            }

            String href = request.getContextPath()
                    + (String) getAttribute(context, component, "outcome")
                    + requestParameters.toString();

            encodeAttribute(writer, "href", href);

            Object value = getAttribute(context, component, "value");
            String valueString = "";
            Converter converter = (Converter) getAttribute(context, component, "converter");
            if (converter != null) {
                valueString = converter.getAsString(value);
            } else if (value != null) {
                valueString = value.toString();
            }
            writer.writeText(valueString);

            writer.endElement("a");
        }
    }
}
