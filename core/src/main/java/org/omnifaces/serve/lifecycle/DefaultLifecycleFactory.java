/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.lifecycle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.omnifaces.serve.cdi.CdiManager;

/**
 * The default life cycle factory.
 */
@ApplicationScoped
public class DefaultLifecycleFactory implements LifecycleFactory {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Get the life cycle.
     *
     * @param context the servlet context.
     * @param config the servlet config.
     * @param request the servlet request.
     * @param response the servlet response.
     * @return the life cycle, or null if not found.
     */
    @Override
    public Lifecycle getLifecycle(ServletContext context,
            ServletConfig config, ServletRequest request, ServletResponse response) {
        Lifecycle result = null;
        if (config != null && config.getInitParameter("org.omnifaces.serve.LifecycleId") != null) {
            String lifecycleId = config.getInitParameter("org.omnifaces.serve.LifecycleId");
            if (cdiManager.exists(Lifecycle.class, new LifecycleIdLiteral(lifecycleId))) {
                result = (Lifecycle) cdiManager.getInstance(Lifecycle.class, new LifecycleIdLiteral(lifecycleId));
            }
        }
        return result;
    }

    /**
     * Get the life cycle.
     *
     * @param context the servlet context.
     * @param config the filter config.
     * @param request the servlet request.
     * @param response the servlet response.
     * @return the life cycle or null if not found.
     */
    @Override
    public Lifecycle getLifecycle(ServletContext context, FilterConfig config,
            ServletRequest request, ServletResponse response) {
        Lifecycle result = null;
        if (config != null && config.getInitParameter("org.omnifaces.serve.LifecycleId") != null) {
            String lifecycleId = config.getInitParameter("org.omnifaces.serve.LifecycleId");
            if (cdiManager.exists(Lifecycle.class, new LifecycleIdLiteral(lifecycleId))) {
                result = (Lifecycle) cdiManager.getInstance(Lifecycle.class, new LifecycleIdLiteral(lifecycleId));
            }
        }
        return result;
    }
}
