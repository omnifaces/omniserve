/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Managed bean for f:validateLongRange showcase #2.
 *
 * 
 */
@Named
@RequestScoped
public class ValidateLongRange2Bean {

    /**
     * Stores the disabled flag.
     */
    private boolean disabled = true;

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
     * Is disabled.
     *
     * @return true if disabled, false otherwise.
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * Set the disabled flag.
     *
     * @param disabled the disabled flag.
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
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
