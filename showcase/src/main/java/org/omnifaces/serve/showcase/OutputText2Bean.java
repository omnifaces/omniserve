/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * The bean for the h:outputText #2.
 *
 * 
 */
@Named
@RequestScoped
public class OutputText2Bean {

    /**
     * Get the text.
     *
     * @return the text.
     */
    public String getText() {
        return "text from OutputText2Bean";
    }
}
