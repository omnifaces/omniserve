/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * A bean for the f:validator showcase #1.
 *
 * 
 */
@Named
@RequestScoped
public class Validator1Bean {

    /**
     * Stores the custom validator.
     */
    private Validator1 custom = new Validator1();

    /**
     * Get the custom validator.
     *
     * @return the custom validator.
     */
    public Validator1 getCustom() {
        return custom;
    }

    /**
     * Set the custom validator.
     *
     * @param custom the custom validator.
     */
    public void setCustom(Validator1 custom) {
        this.custom = custom;
    }

    /**
     * Perform the action.
     *
     * @return null to return to the same page.
     */
    public String doIt() {
        return null;
    }
}
