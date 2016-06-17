/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.rest;

import javax.enterprise.context.ApplicationScoped;
import org.omnifaces.serve.context.Context;

/**
 * The default responder.
 */
@ApplicationScoped
public class DefaultResponder implements Responder {

    /**
     * Respond.
     *
     * @param context the context.
     * @param result the result.
     */
    @Override
    public void respond(Context context, Object result) {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
