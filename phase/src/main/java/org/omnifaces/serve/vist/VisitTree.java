/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.vist;

/**
 * The tree visit interface.
 *
 * @param <C> context.
 * @param <T> target.
 */
public interface VisitTree<C, T> {

    /**
     * Is the component visitable.
     *
     * @param context the visit context.
     * @param component the component.
     * @return true if it is, false otherwise.
     */
    boolean isVisitable(C context, T component);

    /**
     * Visit the tree.
     *
     * @param context the context.
     * @param component the UI component.
     * @param callback the call back.
     * @return true if we are done, false otherwise.
     */
    boolean visitTree(C context, T component, VisitCallback callback);
}
