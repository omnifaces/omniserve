/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.context;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import org.omnifaces.serve.cdi.CdiManager;
import org.omnifaces.serve.lifecycle.Lifecycle;

/**
 * The context factory.
 */
@ApplicationScoped
@Default
public class DefaultContextFactory implements ContextFactory {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Get the context.
     *
     * @param context the context.
     * @param request the request.
     * @param response the response.
     * @param lifecycle the life-cycle.
     * @return the context.
     */
    @Override
    public Context getContext(Object context, Object request, Object response, Lifecycle lifecycle) {
        Context result = (Context) cdiManager.getInstance(lifecycle.getContextInterface());
        result.setResponse((HttpServletResponse) response);
        return result;
    }
}
