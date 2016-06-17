/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.rest;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.lifecycle.Lifecycle;
import org.omnifaces.serve.lifecycle.LifecycleId;

/**
 * The REST life cycle.
 */
@ApplicationScoped
@LifecycleId("REST")
public class RestLifecycle implements Lifecycle {

    /**
     * Stores the method invoker.
     */
    @Inject
    private MethodInvoker methodInvoker;

    /**
     * Stores the request mapper.
     */
    @Inject
    private RequestMapper requestMapper;

    /**
     * Stores the responder.
     */
    @Inject
    private Responder responder;

    /**
     * Execute.
     *
     * @param context the context.
     */
    @Override
    public void execute(Context context) {
        Method method = requestMapper.getMethod(context);
        if (method != null) {
            MethodResult result = methodInvoker.invoke(context, method);
            responder.respond(context, result);
        } else {
            try {
                HttpServletResponse response = context.getResponse();
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            } catch (IOException ioe) { // NOPMD
            }
        }
    }

    /**
     * Get the context interface.
     *
     * @return the context interface.
     */
    @Override
    public Class getContextInterface() {
        return null;
    }

    /**
     * Get the id.
     *
     * @return the id.
     */
    @Override
    public String getId() {
        return "REST";
    }
}
