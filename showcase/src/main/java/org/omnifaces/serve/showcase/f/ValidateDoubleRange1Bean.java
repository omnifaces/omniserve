/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Managed bean for f:validateDoubleRange showcase #1.
 *
 * 
 */
@Named
@RequestScoped
public class ValidateDoubleRange1Bean {

    /**
     * Stores the value.
     */
    private Double value;

    /**
     * Get the value.
     *
     * @return the value.
     */
    public Double getValue() {
        return value;
    }

    /**
     * Set the value.
     *
     * @param value the value.
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * Do it!
     *
     * @return null.
     */
    public String doIt() {
        return null;
    }
}
