/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.extensionless;

import java.net.MalformedURLException;
import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.lifecycle.Lifecycle;
import org.omnifaces.serve.lifecycle.LifecycleFactory;

/**
 * Extensionless decorator.
 */
@Decorator
@Priority(1000)
public abstract class ExtensionlessDecorator implements LifecycleFactory {

    /**
     * Stores the delegate.
     */
    @Inject
    @Delegate
    @Default
    private LifecycleFactory lifecycleFactory;

    /**
     * Get the life cycle.
     *
     * @param context the servlet context.
     * @param config the filter config.
     * @param request the request.
     * @param response the response.
     * @return the life cycle, or null if not found.
     */
    @Override
    public Lifecycle getLifecycle(ServletContext context, FilterConfig config,
            ServletRequest request, ServletResponse response) {
        Lifecycle result = null;
        if (config.getInitParameter("org.omnifaces.serve.ExtensionLess") != null
                && config.getInitParameter("org.omnifaces.serve.ExtensionLess").equals("true")) {
            if (request instanceof HttpServletRequest) {
                HttpServletRequest httpRequest = (HttpServletRequest) request;
                try {
                    String path = httpRequest.getRequestURI();
                    path = path.substring(httpRequest.getContextPath().length());
                    if (!path.contains(".") && context.getResource("/WEB-INF/views" + path + ".xhtml") != null) {
                        result = lifecycleFactory.getLifecycle(context, config, request, response);
                    }
                } catch (MalformedURLException mue) { // NOPMD
                }
            }
        } else {
            result = lifecycleFactory.getLifecycle(context, config, request, response);
        }
        return result;
    }
}
