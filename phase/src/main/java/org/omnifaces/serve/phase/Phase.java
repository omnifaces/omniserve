/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

/**
 * The interface of a phase.
 */
public interface Phase {

    /**
     * Execute the phase.
     *
     * @param context the context.
     */
    void execute(PhaseContext context);

    /**
     * Get the phase id.
     *
     * @return the phase id.
     */
    PhaseId getId();
}
