/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import org.omnifaces.serve.event.AbortProcessingException;
import org.omnifaces.serve.event.ValueChangeEvent;
import org.omnifaces.serve.event.ValueChangeListener;

/**
 * Value change listener for f:valueChangeListener showcase #1.
 *
 * 
 */
public class ValueChangeListener1ValueChangeListener implements ValueChangeListener {

    /**
     * Process the value change.
     *
     * @param event the value change event.
     * @throws AbortProcessingException when processing should be aborted.
     */
    @Override
    public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
    }
}
