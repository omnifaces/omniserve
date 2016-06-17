/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.viewcache;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.el.ValueExpression;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.serve.ext.processor.f.ViewProcessor;

/**
 * A decorator around the f:view processor for view caching.
 */
@Decorator
@Priority(1000)
public abstract class ViewProcessorDecorator extends ServeTagProcessor {

    /**
     * Inject the delegate.
     */
    @Inject
    @Delegate
    @Any
    private ViewProcessor processor;

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        processor.process(context, parent, index);
        if (processor.getAttributes().containsKey("cached")) {
            String attributeString = processor.getAttributes().get("cached").getValue();
            ValueExpression ve = context.getExpressionFactory().createValueExpression(
                    context.getContext().getELContext(), attributeString, boolean.class);
            context.getContext().getViewRoot().setValueExpression("cached", ve);
        }
    }
}
