/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.vist;

/**
 * The visit context.
 *
 * @param <T> the target type.
 */
public interface VisitContext<T> {

    /**
     * Invoke the visit call back.
     *
     * @param target the target.
     * @param callback the call back.
     * @return the visit result.
     */
    VisitResult invokeVisitCallback(T target, VisitCallback callback);
}
