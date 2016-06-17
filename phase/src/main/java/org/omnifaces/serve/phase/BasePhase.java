/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

/**
 * The base implementation of a normal phase.
 */
abstract class BasePhase implements Phase {

    /**
     * Should we skip.
     *
     * @param context the context.
     * @return true if we should, false otherwise.
     */
    protected boolean shouldSkip(PhaseContext context) {
        boolean result = false;
        if (context.getResponseComplete()) {
            result = true;
        } else if (context.getRenderResponse() && !PhaseId.RENDER_RESPONSE.equals(getId())) {
            result = true;
        }
        return result;
    }
}
