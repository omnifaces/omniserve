/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.el.FunctionMapper;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import org.omnifaces.serve.cdi.CdiManager;

/**
 * The default function mapper.
 */
@Dependent
public class DefaultServeFunctionMapper extends FunctionMapper implements ServeFunctionMapper {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Stores the] URI to prefix mappings.
     */
    private final Map<String, String> uriMappings;

    /**
     * Constructor.
     */
    public DefaultServeFunctionMapper() {
        uriMappings = new HashMap<>();
        uriMappings.put("fn", "http://www.omnifaces.org/serve/ext/functions");
    }

    /**
     * Resolve the function.
     *
     * @param prefix the prefix.
     * @param localName the local name.
     * @return the method, or null if not found.
     */
    @Override
    public Method resolveFunction(String prefix, String localName) {
        String uri = uriMappings.get(prefix);
        Object clazz = cdiManager.getInstance(Object.class, new ServeFunctionLiteral(uri, localName));
        Method method = clazz.getClass().getMethods()[0];
        return method;
    }
}
