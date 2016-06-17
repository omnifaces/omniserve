/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.converter;

import java.util.Locale;
import javax.inject.Inject;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIOutput;
import org.omnifaces.serve.converter.ConverterFactory;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:convertNumber.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/converter", localName = "convertNumber")
public class ConvertNumberProcessor extends ServeAttachedObjectProcessor {

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
        UIOutput output = getClosestParent(parent, UIOutput.class);

        NumberConverter converter = (NumberConverter) converterFactory
                .createConverter("org.omnifaces.serve.ext.converter.NumberConverter");
        output.setConverter(converter);

        if (attributes.containsKey("currencyCode")) {
            converter.setCurrencyCode((String) context.evaluate(
                    attributes.get("currencyCode").getValue(), String.class));
        }

        if (attributes.containsKey("currencySymbol")) {
            converter.setCurrencySymbol((String) context.evaluate(
                    attributes.get("currencySymbol").getValue(), String.class));
        }

        if (attributes.containsKey("groupingUsed")) {
            converter.setGroupingUsed((Boolean) context.evaluate(
                    attributes.get("groupingUsed").getValue(), Boolean.class));
        }

        if (attributes.containsKey("integerOnly")) {
            converter.setIntegerOnly((Boolean) context.evaluate(
                    attributes.get("integerOnly").getValue(), Boolean.class));
        }

        if (attributes.containsKey("locale")) {
            Object locale = context.evaluate(attributes.get("locale").getValue(), Object.class);
            if (locale == null) {
                locale = context.getContext().getLocale();
            }
            if (locale instanceof Locale) {
                converter.setLocale((Locale) locale);
            } else {
                converter.setLocale(new Locale((String) locale, ""));
            }
        } else {
            converter.setLocale(Locale.getDefault());
        }

        if (attributes.containsKey("maxFractionDigits")) {
            converter.setMaxFractionDigits((Integer) context.evaluate(
                    attributes.get("maxFractionDigits").getValue(), Integer.class));
        }

        if (attributes.containsKey("maxIntegerDigits")) {
            converter.setMaxIntegerDigits((Integer) context.evaluate(
                    attributes.get("maxIntegerDigits").getValue(), Integer.class));
        }

        if (attributes.containsKey("minFractionDigits")) {
            converter.setMinFractionDigits((Integer) context.evaluate(
                    attributes.get("minFractionDigits").getValue(), Integer.class));
        }

        if (attributes.containsKey("minIntegerDigits")) {
            converter.setMinIntegerDigits((Integer) context.evaluate(
                    attributes.get("minIntegerDigits").getValue(), Integer.class));
        }

        if (attributes.containsKey("pattern")) {
            converter.setPattern((String) context.evaluate(attributes.get("pattern").getValue(), String.class));
        }

        if (attributes.containsKey("type")) {
            converter.setType((String) context.evaluate(attributes.get("type").getValue(), String.class));
        }
    }
}
