/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.ValueHolder;
import org.omnifaces.serve.converter.Converter;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:outputLabel.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlOutputLabel")
public class HtmlOutputLabelRenderer extends BaseRenderer {

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

            writer.startElement("label");

            Object value = getAttribute(context, component, "value");

            String valueString = getConvertedValue((ValueHolder) component, value);

            Boolean escape = (Boolean) getAttribute(context, component, "escape");
            if (escape == null) {
                escape = true;
            }

            if (!escape) {
                writer.write(valueString);
            } else {
                writer.writeText(valueString);
            }

            writer.endElement("label");
        }
    }

    /**
     * Get the converted value.
     *
     * @param valueHolder the value holder.
     * @param value the value.
     * @return the converted value.
     */
    protected String getConvertedValue(ValueHolder valueHolder, Object value) {
        String result;
        Converter converter = valueHolder.getConverter();
        if (converter != null) {
            result = converter.getAsString(value);
        } else if (value != null) {
            result = value.toString();
        } else {
            result = "";
        }
        return result;
    }
}
