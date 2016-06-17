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
 * The processor for f:validateBean.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/validator", localName = "validateBean")
public class ValidateBeanProcessor extends ServeAttachedObjectProcessor {

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
        BeanPropertyValidator validator = new BeanPropertyValidator();
        if (attributes.containsKey("validationGroups")) {
            String validationGroups = (String) context.evaluate(
                    attributes.get("validationGroups").getValue(), String.class);
            validator.setValidationGroups(validationGroups);
        }
        input.addValidator(validator);
    }
}
