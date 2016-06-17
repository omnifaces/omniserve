/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.event;

/**
 * A value change listener.
 */
public interface ValueChangeListener {

    /**
     * Process the value change.
     *
     * @param event the value change event.
     * @throws AbortProcessingException when processing should be aborted.
     */
    void processValueChange(ValueChangeEvent event) throws AbortProcessingException;
}
