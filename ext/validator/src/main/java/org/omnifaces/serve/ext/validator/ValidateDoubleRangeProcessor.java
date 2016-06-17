/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.validator;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIInput;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:validateDoubleRange.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/validator", localName = "validateDoubleRange")
public class ValidateDoubleRangeProcessor extends ServeAttachedObjectProcessor {

    // TODO support disabled attribute.
    // TODO support for attribute.
    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        UIInput input = getClosestParent(parent, UIInput.class);
        DoubleRangeValidator validator = new DoubleRangeValidator();
        if (attributes.containsKey("maximum")) {
            Double maximum = (Double) context.evaluate(attributes.get("maximum").getValue(), Double.class);
            validator.setMaximum(maximum);
        }
        if (attributes.containsKey("minimum")) {
            Double maximum = (Double) context.evaluate(attributes.get("minimum").getValue(), Double.class);
            validator.setMinimum(maximum);
        }
        input.addValidator(validator);
    }
}
