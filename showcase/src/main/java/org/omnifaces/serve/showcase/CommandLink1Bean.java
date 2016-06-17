/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * The h:commandLink showcase #1.
 *
 * 
 */
@Named
@RequestScoped
public class CommandLink1Bean {

    /**
     * Stores the text.
     */
    private String text;

    /**
     * Perform the action.
     *
     * @return null.
     */
    public String doIt() {
        text = "And we replaced it";
        return null;
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
     * Set the text.
     *
     * @param text the text.
     */
    public void setText(String text) {
        this.text = text;
    }
}
