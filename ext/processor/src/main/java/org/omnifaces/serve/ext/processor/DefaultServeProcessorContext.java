/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.el.VariableMapper;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.omnifaces.serve.cdi.CdiManager;
import org.omnifaces.serve.component.ComponentFactory;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.template.DefaultProcessorContext;
import org.omnifaces.template.DefaultXmlParser;
import org.omnifaces.template.ProcessorContext;
import org.omnifaces.template.TagProcessorFactory;

/**
 * The Serve processor context.
 */
@Dependent
public class DefaultServeProcessorContext extends DefaultProcessorContext implements ServeProcessorContext {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Stores the component factory.
     */
    @Inject
    private ComponentFactory componentFactory;

    /**
     * Stores the processing flag.
     */
    private boolean processing = true;

    /**
     * Stores the context.
     */
    @Inject
    private PhaseContext context;

    /**
     * Stores the Servlet context.
     */
    @Inject
    private ServletContext servletContext;

    /**
     * Stores the tag processor factory.
     */
    @Inject
    private ServeTagProcessorFactory tagProcessorFactory;

    /**
     * Create the component.
     *
     * @param componentType the component type.
     * @return the component.
     */
    @Override
    public UIComponent createComponent(String componentType) {
        return componentFactory.createComponent(componentType);
    }

    /**
     * Create the method expression.
     *
     * @param meString the method expression string.
     * @param resultClass the result class.
     * @param types the parameter types.
     * @return the method expression.
     */
    public MethodExpression createMethodExpression(String meString, Class resultClass, Class[] types) {
        return getExpressionFactory().createMethodExpression(context.getELContext(), meString, resultClass, types);
    }

    /**
     * Create the processor for the given view id.
     *
     * @param viewId the view id.
     * @return the tag processor.
     */
    @Override
    public ServeTagProcessor createProcessor(String viewId) {
        ServeDefaultHandler2 serveDefaultHandler2 = cdiManager.getInstance(ServeDefaultHandler2.class);
        return createProcessor(viewId, serveDefaultHandler2);
    }

    /**
     * Create the processor with the given ServeDefaultHandler2.
     *
     * @param viewId the view id.
     * @param defaultHandler2 the ServeDefaultHandler2.
     * @return the processor.
     */
    @Override
    public ServeTagProcessor createProcessor(String viewId, ServeDefaultHandler2 defaultHandler2) {
        ServeTagProcessor result;
        TagProcessorFactory factory = TagProcessorFactory.class.cast(tagProcessorFactory);
        defaultHandler2.setTextProcessorClass(TextProcessor.class);
        DefaultXmlParser xmlParser = new DefaultXmlParser(RootProcessor.class,
                (TagProcessorFactory<ProcessorContext, Object>) factory, defaultHandler2);
        try (InputStream inputStream = getViewUrl(viewId).openStream()) {
            result = ServeTagProcessor.class.cast(xmlParser.parse(inputStream));
        } catch (IOException ioe) {
            result = null;
        }
        return result;
    }

    /**
     * Create a value expression.
     *
     * @param veString the value expression string.
     * @param resultClass the result class.
     * @return the value expression.
     */
    @Override
    public ValueExpression createValueExpression(String veString, Class resultClass) {
        return getExpressionFactory().createValueExpression(context.getELContext(), veString, resultClass);
    }

    /**
     * Evaluate the given EL expression.
     *
     * @param expression the EL expression.
     * @param resultClass the result class.
     * @return the result.
     */
    @Override
    public Object evaluate(String expression, Class resultClass) {
        return createValueExpression(expression, resultClass).getValue(context.getELContext());
    }

    /**
     * Get the expression factory.
     *
     * @return the expression factory.
     */
    @Override
    public ExpressionFactory getExpressionFactory() {
        return ExpressionFactory.newInstance();
    }

    /**
     * Get the context.
     *
     * @return the context.
     */
    @Override
    public PhaseContext getContext() {
        return context;
    }

    /**
     * Get the variable mapper.
     *
     * @return the variable mapper.
     */
    @Override
    public VariableMapper getVariableMapper() {
        return context.getELContext().getVariableMapper();
    }

    /**
     * Get the view URL for the given view id.
     *
     * @param viewId the view id.
     * @return the view URL.
     */
    public URL getViewUrl(String viewId) {
        URL result;
        try {
            result = servletContext.getResource("/WEB-INF/views" + viewId);
        } catch (MalformedURLException mue) {
            result = null;
        }
        return result;
    }

    /**
     * Are we processing?
     *
     * @return true if we are, false otherwise.
     */
    @Override
    public boolean isProcessing() {
        return processing;
    }

    /**
     * Set the processing flag.
     *
     * @param processing the processing flag.
     */
    @Override
    public void setProcessing(boolean processing) {
        this.processing = processing;
    }

    /**
     * Set the context.
     *
     * @param context the context.
     */
    @Override
    public void setContext(PhaseContext context) {
        this.context = context;
    }
}
