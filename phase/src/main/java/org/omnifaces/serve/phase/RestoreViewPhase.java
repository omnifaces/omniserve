/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.view.ViewHandler;

/**
 * The "RESTORE_VIEW" phase.
 */
@ApplicationScoped
@Default
@ServePhaseId("RESTORE_VIEW")
public class RestoreViewPhase extends BasePhase {

    /**
     * Stores the request.
     */
    @Inject
    private HttpServletRequest request;

    /**
     * Stores the view handler.
     */
    @Inject
    private ViewHandler viewHandler;

    /**
     * Execute the phase.
     *
     * @param context the context.
     */
    @Override
    public void execute(PhaseContext context) {
        context.setCurrentPhaseId(getId());
        viewHandler.initView(context);
        UIViewRoot viewRoot = context.getViewRoot();
        if (viewRoot != null && !context.isPostback()) {
            context.renderResponse();
        } else {
            String viewId = (String) request.getAttribute("javax.servlet.include.path_info");
            if (viewId == null) {
                viewId = request.getPathInfo();
            }
            if (viewId == null) {
                viewId = (String) request.getAttribute("javax.servlet.include.servlet_path");
            }
            if (viewId == null) {
                viewId = request.getServletPath();
            }
            if (viewId == null) {
                throw new RuntimeException("Unable to match a view");
            }
            if (context.isPostback()) {
                viewRoot = viewHandler.restoreView(context, viewId);
                context.setViewRoot(viewRoot);
            } else {
                viewRoot = viewHandler.createView(context, viewId);
                context.setViewRoot(viewRoot);
                viewHandler.buildView(context);
            }
        }
    }

    /**
     * Get the phase id.
     *
     * @return the phase id.
     */
    @Override
    public PhaseId getId() {
        return PhaseId.RESTORE_VIEW;
    }
}
