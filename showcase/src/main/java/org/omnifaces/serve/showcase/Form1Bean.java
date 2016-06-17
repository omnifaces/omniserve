/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Bean for h:form showcase #1.
 *
 *
 */
@Named
@RequestScoped
public class Form1Bean {

    /**
     * Stores the text.
     */
    private String text;

    /**
     * Get the text.
     *
     * @return the text.
     */
    public String getText() {
        return text;
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
     * Perform doIt action.
     *
     * @return null.
     */
    public String doIt() {
        return null;
    }
}
