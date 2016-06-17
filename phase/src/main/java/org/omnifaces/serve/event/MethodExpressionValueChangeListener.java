/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.event;

import javax.el.MethodExpression;

/**
 * A method expression value change listener.
 */
public class MethodExpressionValueChangeListener implements ValueChangeListener {

    /**
     * Constructor.
     *
     * @param methodExpression the method expression.
     */
    public MethodExpressionValueChangeListener(MethodExpression methodExpression) { // NOPMD
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Process the value change event.
     *
     * @param event the value change event.
     * @throws AbortProcessingException when processing should be aborted.
     */
    @Override
    public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
