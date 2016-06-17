/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.lifecycle;

import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * The life cycle factory.
 */
public interface LifecycleFactory {

    /**
     * Get the life cycle.
     *
     * @param context the servlet context.
     * @param config the servlet config.
     * @param request the servlet request.
     * @param response the servlet response.
     * @return the life cycle, or null if not found.
     */
    Lifecycle getLifecycle(ServletContext context,
            ServletConfig config, ServletRequest request,
            ServletResponse response);

    /**
     * Get the life cycle.
     *
     * @param context the servlet context.
     * @param config the filter config.
     * @param request the servlet request.
     * @param response the servlet response.
     * @return the life cycle, or null if not found.
     */
    Lifecycle getLifecycle(ServletContext context,
            FilterConfig config, ServletRequest request,
            ServletResponse response);
}
