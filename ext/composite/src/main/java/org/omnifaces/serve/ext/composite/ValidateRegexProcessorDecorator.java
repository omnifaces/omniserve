/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import org.omnifaces.serve.ext.validator.RegexValidator;
import org.omnifaces.serve.ext.validator.ValidateRegexProcessor;
import java.util.List;
import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;

/**
 * A decorator around the f:validateRegex processor for composite component
 * functionality.
 */
@Decorator
@Priority(1000)
public abstract class ValidateRegexProcessorDecorator extends ServeAttachedObjectProcessor {

    /**
     * Inject the delegate.
     */
    @Inject
    @Delegate
    @Any
    private ValidateRegexProcessor processor;

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
            RegexValidator validator = new RegexValidator();
            String pattern = (String) context.evaluate(attributes.get("pattern").getValue(), String.class);
            validator.setPattern(pattern);
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
