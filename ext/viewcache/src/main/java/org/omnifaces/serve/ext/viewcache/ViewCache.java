/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.viewcache;

import org.omnifaces.serve.component.UIViewRoot;

/**
 * The interface for a view cache.
 */
public interface ViewCache {

    /**
     * Get the view root.
     *
     * @param viewId the view id.
     * @return the view root.
     */
    UIViewRoot get(String viewId);

    /**
     * Put the view root.
     *
     * @param viewId the view id.
     * @param viewRoot the view root.
     */
    void put(String viewId, UIViewRoot viewRoot);
}
