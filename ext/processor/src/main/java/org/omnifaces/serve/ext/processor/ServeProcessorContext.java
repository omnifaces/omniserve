/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.el.VariableMapper;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.template.ProcessorContext;

/**
 * The Serve processor context.
 */
public interface ServeProcessorContext extends ProcessorContext {

    /**
     * Create the component.
     *
     * @param componentType the component type.
     * @return the component.
     */
    UIComponent createComponent(String componentType);

    /**
     * Create the processor for the given view id.
     *
     * @param viewId the view id.
     * @return the tag processor.
     */
    ServeTagProcessor createProcessor(String viewId);

    /**
     * Create the processor with the given ServeDefaultHandler2.
     *
     * @param viewId the view id.
     * @param defaultHandler2 the ServeDefaultHandler2.
     * @return the processor.
     */
    ServeTagProcessor createProcessor(String viewId, ServeDefaultHandler2 defaultHandler2);

    /**
     * Create a value expression.
     *
     * @param veString the value expression string.
     * @param resultClass the result class.
     * @return the value expression.
     */
    ValueExpression createValueExpression(String veString, Class resultClass);

    /**
     * Evaluate the given EL expression.
     *
     * @param expression the EL expression.
     * @param resultClass the result class.
     * @return the result.
     */
    Object evaluate(String expression, Class resultClass);

    /**
     * Get the context.
     *
     * @return the context.
     */
    PhaseContext getContext();

    /**
     * Get the expression factory.
     *
     * @return the expression factory.
     */
    ExpressionFactory getExpressionFactory();

    /**
     * Get the variable mapper.
     *
     * @return the variable mapper.
     */
    VariableMapper getVariableMapper();

    /**
     * Are we processing?
     *
     * @return true if we are, false otherwise.
     */
    boolean isProcessing();

    /**
     * Set the context.
     *
     * @param context the context.
     */
    void setContext(PhaseContext context);

    /**
     * Set the processing flag.
     *
     * @param processing the processing flag.
     */
    void setProcessing(boolean processing);
}
