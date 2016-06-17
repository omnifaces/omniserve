/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.vist;

/**
 * The definition of a visit callback.
 *
 * @param <C> the context type.
 * @param <T> the target type.
 */
public interface VisitCallback<C, T> {

    /**
     * Visit.
     *
     * @param context the context.
     * @param target the target.
     * @return the visit result.
     */
    VisitResult visit(C context, T target);
}
