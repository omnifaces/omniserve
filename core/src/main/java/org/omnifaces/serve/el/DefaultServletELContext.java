/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.el;

import javax.el.ArrayELResolver;
import javax.el.BeanELResolver;
import javax.el.CompositeELResolver;
import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.FunctionMapper;
import javax.el.VariableMapper;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import org.omnifaces.serve.cdi.CdiManager;

/**
 * The EL context in a servlet environment.
 */
@Dependent
public class DefaultServletELContext extends ELContext implements ServeELContext {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Stores the EL resolver.
     */
    private CompositeELResolver elResolver;

    /**
     * Stores the function mapper.
     */
    private FunctionMapper functionMapper;

    /**
     * Stores the variable mapper.
     */
    private final VariableMapper variableMapper;

    /**
     * Constructor.
     */
    public DefaultServletELContext() {
        this.variableMapper = new ServeServletVariableMapper();
    }

    /**
     * Get the EL resolver.
     *
     * @return the EL resolver.
     */
    @Override
    public ELResolver getELResolver() {
        if (elResolver == null) {
            elResolver = new CompositeELResolver();
            elResolver.add(cdiManager.getELResolver());
            elResolver.add(new ArrayELResolver());
            elResolver.add(new BeanELResolver());
            elResolver.add(cdiManager.getInstance(HttpServletRequestELResolver.class));
            elResolver.add(cdiManager.getInstance(ScopedAttributeELResolver.class));
        }
        return elResolver;
    }

    /**
     * Get the function mapper.
     *
     * @return the function mapper.
     */
    @Override
    public FunctionMapper getFunctionMapper() {
        return functionMapper;
    }

    /**
     * Get the variable mapper.
     *
     * @return the variable mapper.
     */
    @Override
    public VariableMapper getVariableMapper() {
        return variableMapper;
    }

    /**
     * Set the function mapper.
     *
     * @param functionMapper the function mapper.
     */
    public void setFunctionMapper(FunctionMapper functionMapper) {
        this.functionMapper = functionMapper;
    }
}
