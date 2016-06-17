/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.converter;

/**
 * A converter exception.
 */
public class ConverterException extends RuntimeException {

    /**
     * Constructor.
     */
    public ConverterException() {
        super();
    }

    /**
     * Constructor.
     *
     * @param cause the cause.
     */
    public ConverterException(Exception cause) {
        super(cause);
    }

    /**
     * Constructor.
     *
     * @param message the message.
     * @param cause the cause.
     */
    public ConverterException(String message, Exception cause) {
        super(message, cause);
    }
}
