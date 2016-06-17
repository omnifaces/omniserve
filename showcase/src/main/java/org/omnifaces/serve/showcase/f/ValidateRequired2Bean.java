/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Managed bean for f:validateRequired showcase #2.
 *
 * 
 */
@Named
@RequestScoped
public class ValidateRequired2Bean {

    /**
     * Stores the disabled flag.
     */
    private boolean disabled = true;

    /**
     * Stores the text.
     */
    private String text;

    /**
     * Is the validator disabled.
     *
     * @return true if disabled, false otherwise
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * Get the text.
     *
     * @return the text.
     */
    public String getText() {
        return text;
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
     * Set the text.
     *
     * @param text the text.
     */
    public void setText(String text) {
        this.text = text;
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
