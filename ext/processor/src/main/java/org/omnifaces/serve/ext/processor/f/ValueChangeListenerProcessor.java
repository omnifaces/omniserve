/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.f;

import org.omnifaces.serve.component.EditableValueHolder;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.event.ValueChangeListener;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:valueChangeListener.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/f", localName = "valueChangeListener")
public class ValueChangeListenerProcessor extends ServeAttachedObjectProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        if (parent instanceof EditableValueHolder) {
            ValueChangeListener valueChangeListener;
            try {
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                Class<?> clazz = Class.forName(attributes.get("type").getValue(), true, classLoader);
                valueChangeListener = (ValueChangeListener) clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            EditableValueHolder editableValueHolder = (EditableValueHolder) parent;
            editableValueHolder.addValueChangeListener(valueChangeListener);
        }
    }
}
