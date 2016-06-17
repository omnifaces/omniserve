/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.converter;

import javax.inject.Inject;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIOutput;
import org.omnifaces.serve.converter.Converter;
import org.omnifaces.serve.converter.ConverterFactory;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:converter.
 */
@TemplateProcessor(uri = "http://www.onnifaces.org/serve/ext/converter", localName = "converter")
public class ConverterProcessor extends ServeAttachedObjectProcessor {

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
        Converter converter = converterFactory.createConverter(
                (String) context.evaluate(attributes.get("converterId").getValue(), String.class));
        UIOutput output = getClosestParent(parent, UIOutput.class);
        output.setConverter(converter);
    }
}
