/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Bean for f:validator showcase #2.
 *
 *
 */
@Named
@RequestScoped
public class Validator2Bean {

    /**
     * Stores the custom validator.
     */
    private Validator2 custom = new Validator2();

    /**
     * Get the custom validator.
     *
     * @return the custom validator.
     */
    public Validator2 getCustom() {
        return custom;
    }

    /**
     * Set the custom validator.
     *
     * @param custom the custom validator.
     */
    public void setCustom(Validator2 custom) {
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
