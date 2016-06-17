/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.rest;

import org.omnifaces.serve.context.Context;

/**
 * The responder.
 */
public interface Responder {

    /**
     * Respond.
     *
     * @param context the context.
     * @param result the result.
     */
    void respond(Context context, Object result);
}
