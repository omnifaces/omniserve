/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.view;

import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.phase.PhaseContext;

/**
 * The view handler.
 */
public interface ViewHandler {

    /**
     * Create the view.
     *
     * @param context the context.
     * @param viewId the view id.
     * @return the view root.
     */
    UIViewRoot createView(PhaseContext context, String viewId);

    /**
     * Build the view.
     *
     * @param context the context.
     */
    void buildView(PhaseContext context);

    /**
     * Get the view language.
     *
     * @param context the context.
     * @param viewId the view id.
     * @return the view language.
     */
    ViewLanguage getViewLanguage(PhaseContext context, String viewId);

    /**
     * Initialize the view.
     *
     * @param context the context.
     */
    void initView(PhaseContext context);

    /**
     * Render the view.
     *
     * @param context the context.
     * @param viewRoot the view root.
     */
    void renderView(PhaseContext context, UIViewRoot viewRoot);

    /**
     * Restore the view.
     *
     * @param context the context.
     * @param viewId the view id.
     * @return the view root.
     */
    UIViewRoot restoreView(PhaseContext context, String viewId);
}
