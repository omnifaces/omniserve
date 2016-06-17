/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.event.ActionEvent;
import org.omnifaces.serve.event.ActionSource;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:commandButton.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlCommandButton")
public class HtmlCommandButtonRenderer extends BaseRenderer {

    /**
     * Stores the HTTP servlet request.
     */
    @Inject
    private HttpServletRequest request;

    /**
     * Decode.
     *
     * @param context the context.
     * @param component the component.
     */
    @Override
    public void decode(PhaseContext context, UIComponent component) {
        String id = (String) component.getValueExpression("id").getValue(context.getELContext());
        if (id != null) {
            Map<String, String[]> requestParameterMap = request.getParameterMap();
            if (requestParameterMap.containsKey(id)) {
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
            writer.startElement("input");
            encodeAttribute(writer, "id", (String) getAttribute(context, component, "id"));
            encodeAttribute(writer, "name", (String) getAttribute(context, component, "id"));
            encodeAttribute(writer, "type", getButtonType(context, component));
            encodeAttribute(writer, "value", (String) getAttribute(context, component, "value"));
            encodePassthroughAttributes(writer, component);
            writer.endElement("input");
        }
    }

    /**
     * Get the button type.
     *
     * @param context the context.
     * @param component the UI component.
     * @return the type.
     */
    private String getButtonType(Context context, UIComponent component) {
        String result = "submit";

        if (component.getValueExpression("type") != null) {
            result = (String) component.getValueExpression("type").getValue(context.getELContext());
        }

        return result;
    }
}
