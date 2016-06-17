/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor;

import java.io.IOException;
import java.io.Writer;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import org.omnifaces.serve.cdi.CdiManager;
import org.omnifaces.serve.component.ComponentFactory;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.RenderKit;
import org.omnifaces.serve.renderkit.Renderer;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.view.ViewHandler;
import org.omnifaces.serve.view.ViewLanguage;

/**
 * The processor view language.
 */
@ApplicationScoped
@Default
public class DefaultProcessorViewLanguage implements ViewLanguage {

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
     * Stores the view handler.
     */
    @Inject
    private ViewHandler viewHandler;

    /**
     * Build the view.
     *
     * @param context the context.
     */
    @Override
    public void buildView(PhaseContext context) {
        ServeProcessorContext processorContext = cdiManager.getInstance(ServeProcessorContext.class);
        processorContext.setContext(context);
        UIViewRoot viewRoot = context.getViewRoot();
        ServeTagProcessor processor = processorContext.createProcessor(viewRoot.getViewId());
        processor.process(processorContext, viewRoot, 0);
    }

    /**
     * Create the response writer.
     *
     * @param context the context.
     * @return the response writer, or null if an error occurs.
     */
    private ResponseWriter createResponseWriter(PhaseContext context) {
        Writer responseOutputWriter;
        try {
            responseOutputWriter = context.getResponse().getWriter();
        } catch (IOException ex) {
            responseOutputWriter = null;
        }
        String characterEncoding = context.getCharacterEncoding();
        ResponseWriter result = context.getRenderKit().createResponseWriter(
                responseOutputWriter, context.getResponse().getContentType(), characterEncoding);
        return result;
    }

    /**
     * Create the view.
     *
     * @param context the context.
     * @param viewId the view id.
     */
    @Override
    public void createView(PhaseContext context, String viewId) {
        UIViewRoot viewRoot = (UIViewRoot) componentFactory.createComponent("org.omnifaces.serve.component.UIViewRoot");
        viewRoot.setViewId(viewId);
        context.setViewRoot(viewRoot);
    }

    /**
     * Get the attribute value.
     *
     * @param context the context.
     * @param component the UI component.
     * @param name the attribute name.
     * @return the value, or null if not found.
     */
    private Object getAttribute(PhaseContext context, UIComponent component, String name) {
        Object result;
        if (component.getValueExpression(name) != null) {
            result = component.getValueExpression(name).getValue(context.getELContext());
        } else {
            result = component.getAttributes().get(name);
        }
        return result;
    }

    /**
     * Get the attribute value.
     *
     * @param context the context.
     * @param component the UI component.
     * @param name the attribute name.
     * @param defaultValue the default value.
     * @return the value, or the default value if not found.
     */
    private Object getAttribute(PhaseContext context, UIComponent component, String name, Object defaultValue) {
        Object result = getAttribute(context, component, name);
        if (result == null) {
            result = defaultValue;
        }
        return result;
    }

    /**
     * Render the view.
     *
     * @param context the context.
     */
    @Override
    public void renderView(PhaseContext context) {
        UIViewRoot viewRoot = context.getViewRoot();
        boolean rendered = (boolean) getAttribute(context, viewRoot, "rendered", Boolean.TRUE);
        if (rendered) {
            ResponseWriter writer = context.getResponseWriter();
            if (writer == null) {
                writer = createResponseWriter(context);
                context.setResponseWriter(writer);
            }
            context.getResponse().setCharacterEncoding(context.getCharacterEncoding());
            writer.startDocument();
            RenderKit renderKit = context.getRenderKit();
            Renderer renderer = renderKit.getRenderer(viewRoot.getFamily(), viewRoot.getRendererType());
            renderer.encode(context, viewRoot);
            writer.endDocument();
            writer.close();
        }
    }

    /**
     * Restore the view.
     *
     * @param context the context.
     * @param viewId the view id.
     */
    @Override
    public void restoreView(PhaseContext context, String viewId) {
        UIViewRoot viewRoot = (UIViewRoot) componentFactory.createComponent("org.omnifaces.serve.component.UIViewRoot");
        viewRoot.setViewId(viewId);
        context.setViewRoot(viewRoot);
        ViewLanguage vdl = viewHandler.getViewLanguage(context, viewRoot.getViewId());
        vdl.buildView(context);
    }
}
