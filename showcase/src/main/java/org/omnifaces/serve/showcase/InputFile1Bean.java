/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 * Bean for h:inputFile showcase #1.
 *
 * 
 */
@Named
@RequestScoped
public class InputFile1Bean {

    /**
     * Stores the part.
     */
    private Part part;

    /**
     * Stores the text.
     *
     */
    private String text;

    /**
     * Get the part.
     *
     * @return the part.
     */
    public Part getPart() {
        return part;
    }

    /**
     * Get the text.
     *
     * @return the text..
     */
    public String getText() {
        return text;
    }

    /**
     * Set the part.
     *
     * @param part the part.
     */
    public void setPart(Part part) {
        this.part = part;
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
     * Do it.
     *
     * @return null.
     */
    public String doIt() {
        this.text = part.toString();
        return null;
    }
}
