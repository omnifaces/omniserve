/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.viewcache;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import org.omnifaces.serve.component.UIViewRoot;

/**
 * The default view cache.
 *
 * <p>
 * This view cache uses a synchronized map to make sure it is thread safe. It is
 * understood that carries a performance penalty. If you want to get rid of that
 * particular penalty it is recommended you deliver your own implementation.
 * </p>
 */
@ApplicationScoped
@Default
public class DefaultViewCache implements ViewCache {

    /**
     * Stores the cache size constant.
     */
    private static final int CACHE_SIZE = 25;

    /**
     * Stores the cached view roots.
     */
    private final Map<String, UIViewRoot> viewRoots;

    /**
     * Constructor.
     */
    public DefaultViewCache() {
        viewRoots = Collections.synchronizedMap(new LinkedHashMap<String, UIViewRoot>() {
            /**
             * Stores the serial version UID.
             */
            private static final long serialVersionUID = 8300976593414373625L;

            /**
             * Remove the eldest entry.
             *
             * @param eldest the eldest entry.
             * @return true if map is full, false otherwise.
             */
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, UIViewRoot> eldest) {
                return size() > CACHE_SIZE;
            }
        });
    }

    /**
     * Get the view root.
     *
     * @param viewId the view id.
     * @return the view root, or <code>null</code> if not found.
     */
    @Override
    public UIViewRoot get(String viewId) {
        return viewRoots.get(viewId);
    }

    /**
     * Put the view root.
     *
     * @param viewId the view id.
     * @param viewRoot the UI view root.
     */
    @Override
    public void put(String viewId, UIViewRoot viewRoot) {
        viewRoots.put(viewId, viewRoot);
    }
}
