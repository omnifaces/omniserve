/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIParameter;
import org.omnifaces.serve.event.ActionEvent;
import org.omnifaces.serve.event.ActionSource;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:commandLink.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlCommandLink")
public class HtmlCommandLinkRenderer extends BaseRenderer {

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
            if (requestParameterMap.containsKey(id + "_hidden")) {
                // TODO change to PhaseContext for all components
                ((PhaseContext) context).addEvent(new ActionEvent((ActionSource) component));
            }
        }

        super.decode(context, component);
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
            /*
             * Write hidden input so we can decode.
             */
            writer.startElement("input");
            encodeAttribute(writer, "id", (String) getAttribute(context, component, "id") + "_hidden");
            encodeAttribute(writer, "name", (String) getAttribute(context, component, "id") + "_hidden");
            encodeAttribute(writer, "type", "hidden");
            encodeAttribute(writer, "value", (String) getAttribute(context, component, "id") + "_hidden");
            encodePassthroughAttributes(writer, component);
            writer.endElement("input");

            /*
             * Write out any f:param children.
             */
            Iterator<UIComponent> children = component.getChildren().iterator();
            while (children.hasNext()) {
                UIComponent child = children.next();
                if (child instanceof UIParameter) {
                    UIParameter parameter = (UIParameter) child;
                    writer.startElement("input");
                    encodeAttribute(writer, "type", "hidden");
                    encodeAttribute(writer, "name", (String) getAttribute(context, parameter, "name"));
                    encodeAttribute(writer, "value", (String) getAttribute(context, parameter, "value"));
                    writer.endElement("input");
                }
            }

            /*
             * Write link so we can click.
             */
            writer.startElement("a");
            encodeAttribute(writer, "id", (String) getAttribute(context, component, "id"));
            encodeAttribute(writer, "name", (String) getAttribute(context, component, "id"));
            writer.writeAttribute("href", "#");
            writer.writeAttribute("onclick", "document.getElementById('"
                    + getAttribute(context, component, "id") + "_hidden').form.submit(); return false;");
            writer.writeText((String) getAttribute(context, component, "value"));
            writer.endElement("a");
        }
    }
}
