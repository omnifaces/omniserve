/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.view;

import org.omnifaces.serve.phase.PhaseContext;

/**
 * The view language.
 */
public interface ViewLanguage {

    /**
     * Build the view.
     *
     * @param context the context.
     */
    void buildView(PhaseContext context);

    /**
     * Create the view.
     *
     * @param context the context.
     * @param viewId the view id.
     */
    void createView(PhaseContext context, String viewId);

    /**
     * Render the view.
     *
     * @param context the context.
     */
    void renderView(PhaseContext context);

    /**
     * Restore the view.
     *
     * @param context the context.
     * @param viewId the view id.
     */
    void restoreView(PhaseContext context, String viewId);
}
