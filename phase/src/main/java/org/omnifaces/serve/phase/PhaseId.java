/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

/**
 * The phase id.
 */
public class PhaseId {

    /**
     * Defines the RESTORE_VIEW phase.
     */
    public static final PhaseId RESTORE_VIEW = new PhaseId("RESTORE_VIEW");

    /**
     * Defines the APPLY_REQUEST_VALUES phase.
     */
    public static final PhaseId APPLY_REQUEST_VALUES = new PhaseId("APPLY_REQUEST_VALUES");

    /**
     * Defines the PROCESS_VALIDATIONS phase.
     */
    public static final PhaseId PROCESS_VALIDATIONS = new PhaseId("PROCESS_VALIDATIONS");

    /**
     * Defines the UPDATE_MODEL_VALUES phase.
     */
    public static final PhaseId UPDATE_MODEL_VALUES = new PhaseId("UPDATE_MODEL_VALUES");

    /**
     * Defines the INVOKE_APPLICATION phase.
     */
    public static final PhaseId INVOKE_APPLICATION = new PhaseId("INVOKE_APPLICATION");

    /**
     * Defines the RENDER_RESPONSE phase.
     */
    public static final PhaseId RENDER_RESPONSE = new PhaseId("RENDER_RESPONSE");

    /**
     * Stores the phase id.
     */
    private final String phaseId;

    /**
     * Constructor.
     *
     * @param phaseId the phase id.
     */
    public PhaseId(String phaseId) {
        this.phaseId = phaseId;
    }

    /**
     * Get the phase id.
     *
     * @return the phase id.
     */
    public String getPhaseId() {
        return phaseId;
    }
}
