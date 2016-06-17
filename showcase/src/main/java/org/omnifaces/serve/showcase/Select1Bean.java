/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Bean for h:select showcase #1.
 *
 * 
 */
@Named
@RequestScoped
public class Select1Bean {

    /**
     * Stores the value.
     */
    private String value;

    /**
     * Get the value.
     *
     * @return the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Set the value.
     *
     * @param value the value.
     */
    public void setValue(String value) {
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
