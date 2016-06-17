/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import javax.el.ValueExpression;
import javax.inject.Inject;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.ValueHolder;
import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.converter.Converter;
import org.omnifaces.serve.converter.ConverterFactory;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:outputText.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlOutputText")
public class HtmlOutputTextRenderer extends BaseRenderer {

    /**
     * Stores the converter factory.
     */
    @Inject
    private ConverterFactory converterFactory;

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

            String styleClass = (String) getAttribute(context, component, "styleClass");
            String style = (String) getAttribute(context, component, "style");
            String dir = (String) getAttribute(context, component, "dir");
            String lang = (String) getAttribute(context, component, "lang");

            boolean span = false;

            if (styleClass != null || style != null || dir != null || lang != null
                    || component.getPassThroughAttributes() != null) {
                span = true;
                writer.startElement("span");
                encodeAttribute(writer, "id", (String) getAttribute(context, component, "id"));
                encodeAttribute(writer, "class", styleClass);
                encodeAttribute(writer, "dir", dir);
                encodeAttribute(writer, "lang", lang);
                encodeAttribute(writer, "role", (String) getAttribute(context, component, "role"));
                encodeAttribute(writer, "title", (String) getAttribute(context, component, "title"));
                encodeAttribute(writer, "style", style);
                encodePassthroughAttributes(writer, component);
            }

            Object value = getAttribute(context, component, "value");

            String valueString = getConvertedValue(context, (ValueHolder) component, value);

            Boolean escape = (Boolean) getAttribute(context, component, "escape");
            if (escape == null) {
                escape = true;
            }

            if (!escape) {
                writer.write(valueString);
            } else {
                writer.writeText(valueString);
            }

            if (span) {
                writer.endElement("span");
            }
        }
    }

    /**
     * Get the converted value.
     *
     * @param context the context.
     * @param valueHolder the value holder.
     * @param value the value.
     * @return the converted value.
     */
    protected String getConvertedValue(Context context, ValueHolder valueHolder, Object value) {
        String result = null;
        Converter converter = valueHolder.getConverter();
        if (converter == null) {
            UIComponent component = (UIComponent) valueHolder;
            ValueExpression ve = (ValueExpression) component.getValueExpression("value");
            if (ve != null) {
                Class<?> expectedType = ve.getType(context.getELContext());
                if (!expectedType.equals(Object.class) && !expectedType.equals(String.class)) {
                    converter = converterFactory.createConverter(expectedType);
                }
            }
        }
        if (converter == null) {
            if (value != null) {
                result = value.toString();
            } else {
                result = "";
            }
        } else {
            result = converter.getAsString(value);
        }
        return result;
    }
}
