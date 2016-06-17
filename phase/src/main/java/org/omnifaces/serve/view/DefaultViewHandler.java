/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.view;

import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.RenderKitFactory;

/**
 * The default view handler.
 */
@ApplicationScoped
@Default
public class DefaultViewHandler implements ViewHandler {

    /**
     * Defines a constant for .xhtml extension.
     */
    private static final String XHTML_EXTENSION = ".xhtml";

    /**
     * Stores the render kit factory.
     */
    @Inject
    private RenderKitFactory renderKitFactory;

    /**
     * Stores the HTTP servlet request.
     */
    @Inject
    private HttpServletRequest request;

    /**
     * Stores the view declaration language factory.
     */
    @Inject
    private ViewLanguageFactory vdlFactory;

    /**
     * Build the view.
     *
     * @param context the context.
     */
    @Override
    public void buildView(PhaseContext context) {
        UIViewRoot viewRoot = context.getViewRoot();
        getViewLanguage(context, viewRoot.getViewId()).buildView(context);
    }

    /**
     * Create the view.
     *
     * @param context the context.
     * @param viewId the view id.
     * @return the view root.
     */
    @Override
    public UIViewRoot createView(PhaseContext context, String viewId) {
        String actualViewId = deriveLogicalViewId(context, viewId);
        getViewLanguage(context, actualViewId).createView(context, actualViewId);
        return context.getViewRoot();
    }

    /**
     * Derive the logical view id.
     *
     * @param context the context.
     * @param viewId the view id.
     * @return the logical view id.
     */
    public String deriveLogicalViewId(PhaseContext context, String viewId) {
        String result = viewId;
        String servletPath = request.getServletPath();
        if (servletPath == null) {
            if (!result.endsWith(XHTML_EXTENSION)) {
                result = result.substring(0, result.lastIndexOf(".")) + XHTML_EXTENSION;
            }
        } else if (!viewId.endsWith(XHTML_EXTENSION)) {
            if (viewId.lastIndexOf(".") != -1) {
                result = viewId.substring(0, viewId.lastIndexOf(".")) + XHTML_EXTENSION;
            } else {
                result = viewId + XHTML_EXTENSION;
            }
        }
        return result;
    }

    /**
     * Get the view language.
     *
     * @param context the context.
     * @param viewId the view id.
     * @return the view declaration language.
     */
    @Override
    public ViewLanguage getViewLanguage(PhaseContext context, String viewId) {
        return vdlFactory.getViewLanguage(viewId);
    }

    /**
     * Initialize the view.
     *
     * @param context the context.
     */
    @Override
    public void initView(PhaseContext context) {
        Map<String, String[]> requestParamMap = request.getParameterMap();
        String renderKitId = null;
        String contentType = null;
        if (requestParamMap.containsKey("org.omnifaces.serve.RenderKitId")) {
            renderKitId = requestParamMap.get("org.omnifaces.serve.RenderKitId")[0];
        }
        if (renderKitId == null) {
            renderKitId = renderKitFactory.getDefaultRenderKitId();
        }
        context.setRenderKit(renderKitFactory.getRenderKit(renderKitId));
        if (requestParamMap.containsKey("org.omnifaces.serve.ResponseContentType")) {
            contentType = requestParamMap.get("org.omnifaces.serve.ResponseContentType")[0];
        }
        if (contentType == null) {
            contentType = "text/html";
        }
        context.getResponse().setContentType(contentType);
    }

    /**
     * Render the view.
     *
     * @param context the context.
     * @param viewRoot the view root.
     */
    @Override
    public void renderView(PhaseContext context, UIViewRoot viewRoot) {
        context.setViewRoot(viewRoot);
        vdlFactory.getViewLanguage(viewRoot.getViewId()).renderView(context);
    }

    /**
     * Restore the view.
     *
     * @param context the context.
     * @param viewId the view id.
     * @return the view root.
     */
    @Override
    public UIViewRoot restoreView(PhaseContext context, String viewId) {
        String actualViewId = deriveLogicalViewId(context, viewId);
        getViewLanguage(context, actualViewId).restoreView(context, actualViewId);
        return context.getViewRoot();
    }
}
