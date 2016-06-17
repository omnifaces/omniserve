/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.view.ViewHandler;

/**
 * The "RENDER_RESPONSE" phase.
 */
@ApplicationScoped
@ServePhaseId("RENDER_RESPONSE")
@Default
public class RenderResponsePhase extends BasePhase {

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
        UIViewRoot viewRoot = context.getViewRoot();
        viewHandler.renderView(context, viewRoot);
    }

    /**
     * Get the phase id.
     *
     * @return the phase id.
     */
    @Override
    public PhaseId getId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
