/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Request-scoped bean for f:converter showcase #1.
 *
 * 
 */
@Named
@RequestScoped
public class Converter1Bean {

    /**
     * Stores the custom type.
     *
     */
    private Converter1 custom = new Converter1();

    /**
     * Get the custom type.
     *
     * @return the custom type.
     */
    public Converter1 getCustom() {
        return custom;
    }

    /**
     * Set the custom type.
     *
     * @param custom the custom type.
     */
    public void setCustom(Converter1 custom) {
        this.custom = custom;
    }
}
