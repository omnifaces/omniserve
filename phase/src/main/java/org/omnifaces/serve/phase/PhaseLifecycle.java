/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.lifecycle.Lifecycle;
import org.omnifaces.serve.lifecycle.LifecycleId;

/**
 * The PHASE lifecycle.
 */
@ApplicationScoped
@LifecycleId("PHASE")
public class PhaseLifecycle implements Lifecycle {

    /**
     * Stores the restore view phase.
     */
    @Inject
    @ServePhaseId("RESTORE_VIEW")
    private Phase restoreViewPhase;

    /**
     * Stores the apply request values phase.
     */
    @Inject
    @ServePhaseId("APPLY_REQUEST_VALUES")
    private Phase applyRequestValuesPhase;

    /**
     * Stores the process validations phase.
     */
    @Inject
    @ServePhaseId("PROCESS_VALIDATIONS")
    private Phase processValidationsPhase;

    /**
     * Stores the update model values phase.
     */
    @Inject
    @ServePhaseId("UPDATE_MODEL_VALUES")
    private Phase updateModelValuesPhase;

    /**
     * Stores the invoke application phase.
     */
    @Inject
    @ServePhaseId("INVOKE_APPLICATION")
    private Phase invokeApplicationPhase;

    /**
     * Stores the render response phase.
     */
    @Inject
    @ServePhaseId("RENDER_RESPONSE")
    private Phase renderResponsePhase;

    /**
     * Execute.
     *
     * @param context the context.
     */
    @Override
    public void execute(Context context) {
        PhaseContext phaseContext = (PhaseContext) context;
        restoreViewPhase.execute(phaseContext);
        if (!(phaseContext.getRenderResponse() || phaseContext.getResponseComplete())) {
            applyRequestValuesPhase.execute(phaseContext);
        }
        if (!(phaseContext.getRenderResponse() || phaseContext.getResponseComplete())) {
            processValidationsPhase.execute(phaseContext);
        }
        if (!(phaseContext.getRenderResponse() || phaseContext.getResponseComplete())) {
            updateModelValuesPhase.execute(phaseContext);
        }
        if (!(phaseContext.getRenderResponse() || phaseContext.getResponseComplete())) {
            invokeApplicationPhase.execute(phaseContext);
        }
        if (!phaseContext.getResponseComplete()) {
            renderResponsePhase.execute(phaseContext);
        }
    }

    /**
     * Get the context interface.
     *
     * @return the context interface.
     */
    @Override
    public Class getContextInterface() {
        return PhaseContext.class;
    }

    /**
     * Get the id.
     *
     * @return the id.
     */
    @Override
    public String getId() {
        return "COMPONENT";
    }
}
