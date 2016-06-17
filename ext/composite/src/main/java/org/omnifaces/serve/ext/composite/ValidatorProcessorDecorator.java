/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import org.omnifaces.serve.ext.validator.ValidatorProcessor;
import java.util.List;
import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.validator.Validator;
import org.omnifaces.serve.validator.ValidatorFactory;

/**
 * A decorator around the f:validator processor for composite component
 * functionality.
 */
@Decorator
@Priority(1000)
public abstract class ValidatorProcessorDecorator extends ServeAttachedObjectProcessor {

    /**
     * Stores the validator factory.
     */
    @Inject
    private ValidatorFactory validatorFactory;

    /**
     * Inject the delegate.
     */
    @Inject
    @Delegate
    @Any
    private ValidatorProcessor processor;

    /**
     * Perform the processing.
     *
     * @param context the processor context.
     * @param parent the parent UI component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        if (attributes.containsKey("for")) {
            Validator validator = validatorFactory.createValidator(attributes.get("validatorId").getValue());
            UIComponent compositeComponent = (UIComponent) getClosestParent(parent, CompositeComponent.class);
            @SuppressWarnings("unchecked")
            List<CompositeComponentAttachedObject> attachedObjects
                    = (List<CompositeComponentAttachedObject>) compositeComponent.getAttributes().get(
                            CompositeComponentProcessor.class.getName() + "_attachedObjects");
            attachedObjects.add(new CompositeComponentAttachedObject(attributes.get("for").getValue(), validator));
        } else {
            processor.process(context, parent, index);
        }
    }
}
