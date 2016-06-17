/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

import java.lang.reflect.Method;

/**
 * A Serve function mapper.
 */
public interface ServeFunctionMapper {

    /**
     * Resolve a function.
     *
     * @param prefix the prefix.
     * @param localName the local name.
     * @return the method.
     */
    Method resolveFunction(String prefix, String localName);
}
