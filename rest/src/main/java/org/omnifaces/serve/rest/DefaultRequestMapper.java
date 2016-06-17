/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.rest;

import java.lang.reflect.Method;
import javax.enterprise.context.ApplicationScoped;
import org.omnifaces.serve.context.Context;

/**
 * The default request mapper.
 */
@ApplicationScoped
public class DefaultRequestMapper implements RequestMapper {

    /**
     * Get the method.
     *
     * @param context the context.
     * @return the method, or null if not found.
     */
    @Override
    public Method getMethod(Context context) {
        return null;
    }
}
