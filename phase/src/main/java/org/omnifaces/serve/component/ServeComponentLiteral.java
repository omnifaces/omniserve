/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import javax.enterprise.util.AnnotationLiteral;

/**
 * The annotation literal for @ServeComponent.
 */
@SuppressWarnings("all")
public class ServeComponentLiteral extends AnnotationLiteral<ServeComponent> implements ServeComponent {

    /**
     * Stores the serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Stores the component type.
     */
    String value;

    /**
     * Constructor.
     *
     * @param value the component type.
     */
    public ServeComponentLiteral(String value) {
        this.value = value;
    }

    /**
     * Get the component type.
     *
     * @return the component type..
     */
    @Override
    public String value() {
        return value;
    }
}
