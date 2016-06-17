/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import org.omnifaces.serve.component.ServeComponent;
import org.omnifaces.serve.component.UIComponentBase;

/**
 * A composite component container.
 */
@ServeComponent("org.omnifaces.serve.ext.composite.UICompositeComponent")
public class UICompositeComponent extends UIComponentBase implements CompositeComponent {

    /**
     * Get the family.
     *
     * @return the family.
     */
    @Override
    public String getFamily() {
        return "org.omnifaces.serve.ext.composite";
    }
}
