/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIParameter;
import org.omnifaces.serve.component.ValueHolder;
import org.omnifaces.serve.converter.Converter;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for h:outputFormat.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.component.html",
        rendererType = "org.omnifaces.serve.component.html.HtmlOutputFormat")
public class HtmlOutputFormatRenderer extends BaseRenderer {

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

            Object value = getAttribute(context, component, "value");

            String valueString = getConvertedValue((ValueHolder) component, value);

            List<Object> parameters = new ArrayList<>();
            Iterator<UIComponent> children = component.getChildren().iterator();
            while (children.hasNext()) {
                UIComponent child = children.next();
                if (child instanceof UIParameter) {
                    UIParameter parameter = (UIParameter) child;
                    parameters.add(getAttribute(context, parameter, "value"));
                }
            }

            if (!parameters.isEmpty()) {
                valueString = MessageFormat.format(valueString, parameters.toArray());
            }

            Boolean escape = (Boolean) getAttribute(context, component, "escape");
            if (escape == null) {
                escape = true;
            }

            if (!escape) {
                writer.write(valueString);
            } else {
                writer.writeText(valueString);
            }
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
