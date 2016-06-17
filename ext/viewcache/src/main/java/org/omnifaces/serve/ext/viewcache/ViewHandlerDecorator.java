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
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.view.ViewHandler;

/**
 * A decorator around the view handler for view caching.
 */
@Decorator
@Priority(1000)
public abstract class ViewHandlerDecorator implements ViewHandler {

    /**
     * Inject the delegate.
     */
    @Inject
    @Delegate
    @Any
    private ViewHandler viewHandler;

    /**
     * Inject the view cache.
     */
    @Inject
    private ViewCache viewCache;

    /**
     * Build the view.
     *
     * @param context the context.
     */
    @Override
    public void buildView(PhaseContext context) {
        UIViewRoot viewRoot = context.getViewRoot();
        if (viewCache.get(viewRoot.getViewId()) != null) {
            context.setViewRoot(viewCache.get(viewRoot.getViewId()));
        } else {
            viewHandler.buildView(context);
            if (viewRoot.getAttributes().containsKey("cached")) {
                ValueExpression ve = (ValueExpression) viewRoot.getAttributes().get("cached");
                boolean cached = (boolean) ve.getValue(context.getELContext());
                if (cached) {
                    viewCache.put(viewRoot.getViewId(), viewRoot);
                }
            }
        }
    }
}
