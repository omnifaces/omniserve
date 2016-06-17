/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit;

/**
 * A renderer.
 *
 * @param <C> the context type.
 * @param <U> the component type.
 */
public interface Renderer<C, U> {

    /**
     * Decode.
     *
     * @param context the context.
     * @param component the UI component.
     */
    default void decode(C context, U component) {
    }

    /**
     * Encode.
     *
     * @param context the context.
     * @param component the UI component.
     */
    default void encode(C context, U component) {
    }
}
