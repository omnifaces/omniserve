/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.extensionless;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.context.ContextFactory;
import org.omnifaces.serve.lifecycle.Lifecycle;
import org.omnifaces.serve.lifecycle.LifecycleFactory;

/**
 * A filter for extensionless processing.
 */
@WebFilter(urlPatterns = {"/*"},
        initParams = {
            @WebInitParam(name = "org.omnifaces.serve.LifecycleId", value = "PHASE"),
            @WebInitParam(name = "org.omnifaces.serve.ExtensionLess", value = "true")})
public class ExtensionlessFilter implements Filter {

    /**
     * Stores the context factory.
     */
    @Inject
    private ContextFactory contextFactory;

    /**
     * Stores the filter config.
     */
    private FilterConfig filterConfig;

    /**
     * Stores the lifecycle factory.
     */
    @Inject
    private LifecycleFactory lifecycleFactory;

    /**
     * Initialize the filter.
     *
     * @param filterConfig the filter config.
     * @throws ServletException when a servlet error occurs.
     */
    @Override
    @SuppressWarnings("checkstyle:hiddenfield")
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    /**
     * Do filter.
     *
     * @param servletRequest the servlet request.
     * @param servletResponse the servlet response.
     * @param filterChain the filter chain.
     * @throws IOException when an I/O error occurs.
     * @throws ServletException when a Servlet error occurs.
     */
    @Override
    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        boolean processChain = true;
        if (servletRequest instanceof HttpServletRequest
                && servletResponse instanceof HttpServletResponse) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            Lifecycle lifecycle = lifecycleFactory.getLifecycle(
                    filterConfig.getServletContext(), filterConfig, request, response);
            if (lifecycle != null) {
                Context context = contextFactory.getContext(
                        filterConfig.getServletContext(), request, response, lifecycle);
                try {
                    lifecycle.execute(context);
                } catch (RuntimeException e) {
                    throw new ServletException(e);
                }
                processChain = false;
            }
        }
        if (processChain) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    /**
     * Destroy the filter.
     */
    @Override
    public void destroy() {
    }
}
