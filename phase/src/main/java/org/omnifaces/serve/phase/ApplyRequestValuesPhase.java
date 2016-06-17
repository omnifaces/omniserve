/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.renderkit.RenderKit;
import org.omnifaces.serve.renderkit.Renderer;

/**
 * The default "APPLY_REQUEST_VALUES" phase.
 */
@ApplicationScoped
@Default
@ServePhaseId("APPLY_REQUEST_VALUES")
public class ApplyRequestValuesPhase extends BasePhase {

    /**
     * Execute the phase.
     *
     * @param context the context.
     */
    @Override
    public void execute(PhaseContext context) {
        context.setCurrentPhaseId(getId());
        if (!shouldSkip(context)) {
            UIViewRoot viewRoot = context.getViewRoot();
            RenderKit renderKit = context.getRenderKit();
            Renderer renderer = renderKit.getRenderer(viewRoot.getFamily(), viewRoot.getRendererType());
            renderer.decode(context, viewRoot);
        }
    }

    /**
     * Get the phase id.
     *
     * @return the phase id.
     */
    @Override
    public PhaseId getId() {
        return PhaseId.APPLY_REQUEST_VALUES;
    }
}
