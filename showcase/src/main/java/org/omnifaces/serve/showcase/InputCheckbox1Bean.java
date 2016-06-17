/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Bean for h:inputCheckbox showcase #1.
 *
 * 
 */
@Named
@RequestScoped
public class InputCheckbox1Bean {

    /**
     * Stores the value.
     */
    private boolean value;

    /**
     * Get the value.
     *
     * @return the value.
     */
    public boolean getValue() {
        return value;
    }

    /**
     * Set the value.
     *
     * @param value the value.
     */
    public void setValue(boolean value) {
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
