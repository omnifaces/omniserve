/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import org.omnifaces.serve.ext.converter.ConverterProcessor;
import java.util.List;
import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.converter.Converter;
import org.omnifaces.serve.converter.ConverterFactory;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;

/**
 * A decorator around the f:converter processor for composite component
 * functionality.
 */
@Decorator
@Priority(1000)
public abstract class ConverterProcessorDecorator extends ServeAttachedObjectProcessor {

    /**
     * Stores the converter factory.
     */
    @Inject
    private ConverterFactory converterFactory;

    /**
     * Stores the decorated processor.
     */
    @Inject
    @Delegate
    @Any
    private ConverterProcessor processor;

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
            Converter converter = converterFactory.createConverter(
                    (String) context.evaluate(attributes.get("converterId").getValue(), String.class));
            UIComponent compositeComponent = (UIComponent) getClosestParent(parent, CompositeComponent.class);
            @SuppressWarnings("unchecked")
            List<CompositeComponentAttachedObject> attachedObjects
                    = (List<CompositeComponentAttachedObject>) compositeComponent.getAttributes().get(
                            CompositeComponentProcessor.class.getName() + "_attachedObjects");
            attachedObjects.add(new CompositeComponentAttachedObject(attributes.get("for").getValue(), converter));
        } else {
            processor.process(context, parent, index);
        }
    }
}
