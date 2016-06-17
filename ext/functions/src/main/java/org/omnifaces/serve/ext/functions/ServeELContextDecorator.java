/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.el.FunctionMapper;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.cdi.CdiManager;
import org.omnifaces.serve.el.ServeELContext;

/**
 * A decorator around ServeELContext.
 */
@Decorator
@Priority(1000)
public class ServeELContextDecorator implements ServeELContext {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Stores the delegate.
     */
    @Inject
    @Delegate
    @Default
    private ServeELContext elContext;

    /**
     * Stores the HTTP servlet request.
     */
    @Inject
    private HttpServletRequest request;

    /**
     * Get the function mapper.
     *
     * @return the function mapper.
     */
    @Override
    public FunctionMapper getFunctionMapper() {
        FunctionMapper result = (FunctionMapper) request.getAttribute(ServeELContextDecorator.class.getName());
        if (result == null) {
            result = (FunctionMapper) cdiManager.getInstance(ServeFunctionMapper.class);
            request.setAttribute(ServeELContextDecorator.class.getName(), result);
        }
        return result;
    }

    /**
     * Set the function mapper.
     *
     * @param functionMapper the function mapper.
     */
    @Override
    public void setFunctionMapper(FunctionMapper functionMapper) {
        elContext.setFunctionMapper(functionMapper);
    }
}
