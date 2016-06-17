/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.validator;

import javax.el.ValueExpression;
import javax.inject.Inject;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIInput;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.validator.Validator;
import org.omnifaces.serve.validator.ValidatorFactory;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:validateRequired.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/validator", localName = "validateRequired")
public class ValidateRequiredProcessor extends ServeAttachedObjectProcessor {

    /**
     * Stores the validator factory.
     */
    @Inject
    private ValidatorFactory validatorFactory;

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        Validator validator = validatorFactory.createValidator(
                "org.omnifaces.serve.ext.validator.RequiredValidator");
        if (attributes.containsKey("disabled")) {
            String attributeString = attributes.get("disabled").getValue();
            ValueExpression ve = context.getExpressionFactory().createValueExpression(
                    context.getContext().getELContext(), attributeString, boolean.class);
            validator.setValueExpression("disabled", ve);
        }
        UIInput input = getClosestParent(parent, UIInput.class);
        input.addValidator(validator);
    }
}
