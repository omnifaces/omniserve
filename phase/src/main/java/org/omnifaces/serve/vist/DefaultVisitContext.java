/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.vist;

import org.omnifaces.serve.component.UIComponent;

/**
 * The default visit context.
 */
public class DefaultVisitContext implements VisitContext<UIComponent> {

    /**
     * Invoke the visit call back.
     *
     * @param component the component.
     * @param callback the call back.
     * @return the visit result.
     */
    @Override
    public VisitResult invokeVisitCallback(UIComponent component, VisitCallback callback) {
        return callback.visit(this, component);
    }
}
