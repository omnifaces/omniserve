/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Request-scoped bean for f:converter showcase #2.
 *
 * 
 */
@Named
@RequestScoped
public class Converter2Bean {

    /**
     * Stores the constant.
     */
    private static final long VALUE = 1234L;

    /**
     * Get the long.
     *
     * @return the long.
     */
    public Long getValue() {
        return VALUE;
    }
}
