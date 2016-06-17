/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.vist;

/**
 * A result during a tree visit.
 */
public enum VisitResult {

    /**
     * Accept to process the sub-tree.
     */
    ACCEPT,
    /**
     * Immediately stop processing.
     */
    COMPLETE,
    /**
     * Reject to process the sub-tree.
     */
    REJECT
}
