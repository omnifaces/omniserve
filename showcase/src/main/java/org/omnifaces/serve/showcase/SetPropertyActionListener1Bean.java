/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * The h:commandButton showcase #1.
 *
 * 
 */
@Named
@RequestScoped
public class SetPropertyActionListener1Bean {

    /**
     * Stores the property.
     */
    private String property;

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
        return null;
    }

    /**
     * Get the property.
     *
     * @return the property.
     */
    public String getProperty() {
        return property;
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
     * Set the property.
     *
     * @param property the property.
     */
    public void setProperty(String property) {
        this.property = property;
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
