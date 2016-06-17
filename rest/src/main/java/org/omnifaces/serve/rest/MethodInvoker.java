/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.rest;

import java.lang.reflect.Method;
import org.omnifaces.serve.context.Context;

/**
 * The method invoker.
 */
public interface MethodInvoker {

    /**
     * Invoke the method.
     *
     * @param context the context.
     * @param method the method.
     * @return the result.
     */
    MethodResult invoke(Context context, Method method);
}
