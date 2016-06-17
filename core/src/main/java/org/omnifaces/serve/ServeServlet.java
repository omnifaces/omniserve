/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.context.ContextFactory;
import org.omnifaces.serve.lifecycle.Lifecycle;
import org.omnifaces.serve.lifecycle.LifecycleFactory;

/**
 * The Serve servlet.
 */
@MultipartConfig
public class ServeServlet implements Servlet {

    /**
     * Stores the context factory.
     */
    @Inject
    private ContextFactory contextFactory;

    /**
     * Stores the lifecycle factory.
     */
    @Inject
    private LifecycleFactory lifecycleFactory;

    /**
     * Stores the servlet config.
     */
    private ServletConfig servletConfig;

    /**
     * Destroy the servlet.
     */
    @Override
    public void destroy() {
    }

    /**
     * Get the servlet configuration.
     *
     * @return the servlet configuration.
     */
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    /**
     * Get the servlet information.
     *
     * @return empty string.
     */
    @Override
    public String getServletInfo() {
        return "";
    }

    /**
     * Initialize the servlet config.
     *
     * @param servletConfig the servlet config.
     * @throws ServletException when the servlet failed to initialize properly.
     */
    @Override
    @SuppressWarnings("checkstyle:hiddenfield")
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    /**
     * Service the request.
     *
     * @param servletRequest the servlet request.
     * @param servletResponse the servlet response.
     * @throws IOException when an I/O error occurs.
     * @throws ServletException when a servlet error occurs.
     */
    @Override
    public void service(ServletRequest servletRequest,
            ServletResponse servletResponse) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Lifecycle lifecycle = lifecycleFactory.getLifecycle(
                servletConfig.getServletContext(), servletConfig, request, response);

        Context context = contextFactory.getContext(
                servletConfig.getServletContext(), request, response, lifecycle);

        try {
            lifecycle.execute(context);
        } catch (RuntimeException e) {
            throw new ServletException(e);
        }
    }
}
