/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.event;

import javax.enterprise.util.AnnotationLiteral;

/**
 * The annotation literal for @ServeActionListener.
 */
@SuppressWarnings("all")
public class ServeActionListenerLiteral extends AnnotationLiteral<ServeActionListener> implements ServeActionListener {

    /**
     * Defines the serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Stores the action listener id.
     */
    private final String value;

    /**
     * Constructor.
     *
     * @param value the converter id.
     */
    public ServeActionListenerLiteral(String value) {
        this.value = value;
    }

    /**
     * Get the action listener id.
     *
     * @return the action listener id.
     */
    @Override
    public String value() {
        return value;
    }
}
