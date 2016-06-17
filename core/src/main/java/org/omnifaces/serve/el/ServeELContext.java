/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.el;

import javax.el.FunctionMapper;

/**
 * A Serve ELContext.
 */
public interface ServeELContext {

    /**
     * Get the function mapper.
     *
     * @return the function mapper.
     */
    FunctionMapper getFunctionMapper();

    /**
     * Set the function mapper.
     *
     * @param functionMapper the function mapper.
     */
    void setFunctionMapper(FunctionMapper functionMapper);
}
