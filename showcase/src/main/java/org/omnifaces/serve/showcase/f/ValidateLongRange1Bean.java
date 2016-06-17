/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Managed bean for f:validateLongRange showcase #1.
 *
 * 
 */
@Named
@RequestScoped
public class ValidateLongRange1Bean {

    /**
     * Stores the value.
     */
    private Long value;

    /**
     * Get the value.
     *
     * @return the value.
     */
    public Long getValue() {
        return value;
    }

    /**
     * Set the value.
     *
     * @param value the value.
     */
    public void setValue(Long value) {
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
