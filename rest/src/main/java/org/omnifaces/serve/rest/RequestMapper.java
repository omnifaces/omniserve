/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.rest;

import java.lang.reflect.Method;
import org.omnifaces.serve.context.Context;

/**
 * The request mapper interface.
 */
public interface RequestMapper {

    /**
     * Get the method.
     *
     * @param context the context.
     * @return the method, or null if not found.
     */
    Method getMethod(Context context);
}
