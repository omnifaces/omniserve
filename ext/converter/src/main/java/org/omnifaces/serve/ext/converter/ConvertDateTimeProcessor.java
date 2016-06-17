/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.converter;

import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.ValueHolder;
import org.omnifaces.serve.converter.ConverterFactory;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:convertDateTime.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/converter", localName = "convertDateTime")
public class ConvertDateTimeProcessor extends ServeAttachedObjectProcessor {

    // TODO support for attribute.
    /**
     * Stores the converter factory.
     */
    @Inject
    private ConverterFactory converterFactory;

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        DateTimeConverter converter = (DateTimeConverter) converterFactory.
                createConverter("org.omnifaces.serve.ext.converter.DateTimeConverter");

        if (attributes.containsKey("dateStyle")) {
            converter.setDateStyle((String) context.evaluate(attributes.get("dateStyle").getValue(), String.class));
        }

        if (attributes.containsKey("locale")) {
            Object locale = context.evaluate(attributes.get("locale").getValue(), Object.class);
            if (locale instanceof Locale) {
                converter.setLocale((Locale) locale);
            } else {
                converter.setLocale(new Locale((String) locale, ""));
            }
        } else {
            converter.setLocale(Locale.getDefault());
        }

        if (attributes.containsKey("pattern")) {
            converter.setPattern((String) context.evaluate(attributes.get("pattern").getValue(), String.class));
        }

        if (attributes.containsKey("timeStyle")) {
            converter.setTimeStyle((String) context.evaluate(attributes.get("timeStyle").getValue(), String.class));
        }

        if (attributes.containsKey("timeZone")) {
            Object timeZone = context.evaluate(attributes.get("timeZone").getValue(), Object.class);
            if (timeZone instanceof TimeZone) {
                converter.setTimeZone((TimeZone) timeZone);
            } else {
                converter.setTimeZone(TimeZone.getTimeZone((String) timeZone));
            }
        }

        if (attributes.containsKey("type")) {
            converter.setType((String) context.evaluate(attributes.get("type").getValue(), String.class));
        }

        ValueHolder valueHolder = getClosestParent(parent, ValueHolder.class);
        valueHolder.setConverter(converter);
    }
}
