/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.rest;

import java.lang.reflect.Method;
import javax.enterprise.context.ApplicationScoped;
import org.omnifaces.serve.context.Context;

/**
 * The default method invoker.
 */
@ApplicationScoped
public class DefaultMethodInvoker implements MethodInvoker {

    /**
     * Invoke the method.
     *
     * @param context the context.
     * @param method the method.
     * @return the result.
     */
    @Override
    public MethodResult invoke(Context context, Method method) {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
