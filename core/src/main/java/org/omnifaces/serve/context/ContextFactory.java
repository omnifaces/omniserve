/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.context;

import org.omnifaces.serve.lifecycle.Lifecycle;

/**
 * The context factory.
 */
public interface ContextFactory {

    /**
     * Get the context.
     *
     * @param context the context.
     * @param request the request.
     * @param response the response.
     * @param lifecycle the life-cycle.
     * @return the context.
     */
    Context getContext(
            Object context,
            Object request,
            Object response,
            Lifecycle lifecycle);
}
