/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import org.omnifaces.serve.ext.processor.f.ValueChangeListenerProcessor;
import java.util.List;
import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.event.ValueChangeListener;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;

/**
 * A decorator around the f:valueChangeListener processor for composite
 * component functionality.
 */
@Decorator
@Priority(1000)
public abstract class ValueChangeListenerProcessorDecorator extends ServeAttachedObjectProcessor {

    /**
     * Inject the delegate.
     */
    @Inject
    @Delegate
    @Any
    private ValueChangeListenerProcessor processor;

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
            ValueChangeListener valueChangeListener;

            try {
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                Class<?> clazz = Class.forName(attributes.get("type").getValue(), true, classLoader);
                valueChangeListener = (ValueChangeListener) clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            UIComponent compositeComponent = (UIComponent) getClosestParent(parent, CompositeComponent.class);
            @SuppressWarnings("unchecked")
            List<CompositeComponentAttachedObject> attachedObjects
                    = (List<CompositeComponentAttachedObject>) compositeComponent.getAttributes().get(
                            CompositeComponentProcessor.class.getName() + "_attachedObjects");
            attachedObjects.add(new CompositeComponentAttachedObject(
                    attributes.get("for").getValue(), valueChangeListener));
        } else {
            processor.process(context, parent, index);
        }
    }
}
