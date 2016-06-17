/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

import javax.enterprise.util.AnnotationLiteral;

/**
 * The annotation literal for @ServeFunction.
 */
@SuppressWarnings("all")
public class ServeFunctionLiteral extends AnnotationLiteral<ServeFunction> implements ServeFunction {

    /**
     * Defines the serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Stores the local name.
     */
    private final String localName;

    /**
     * Stores the URI.
     */
    private final String uri;

    /**
     * Constructor.
     *
     * @param uri the URI.
     * @param localName the local name.
     */
    public ServeFunctionLiteral(String uri, String localName) {
        this.uri = uri;
        this.localName = localName;
    }

    /**
     * Get the local name.
     *
     * @return the local name.
     */
    @Override
    public String localName() {
        return localName;
    }

    /**
     * Get the URI.
     *
     * @return the prefix.
     */
    @Override
    public String uri() {
        return uri;
    }
}
