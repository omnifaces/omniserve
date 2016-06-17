/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * A bean for the h:inputText showcase #2.
 *
 * 
 */
@Named
@RequestScoped
public class InputText2Bean {

    /**
     * Stores the custom InputText2 object.
     */
    private InputText2 custom = new InputText2();

    /**
     * Get the custom InputText2 object.
     *
     * @return the custom InputText2 object.
     */
    public InputText2 getCustom() {
        return custom;
    }

    /**
     * Set the custom InputText2 object.
     *
     * @param custom the custom InputText2 object.
     */
    public void setCustom(InputText2 custom) {
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
