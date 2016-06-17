/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

/**
 * A UI parameter.
 */
@ServeComponent("org.omnifaces.serve.component.UIParameter")
public class UIParameter extends UIComponentBase {

    /**
     * Get the family.
     *
     * @return the family.
     */
    @Override
    public String getFamily() {
        return "org.omnifaces.serve.component";
    }
}
