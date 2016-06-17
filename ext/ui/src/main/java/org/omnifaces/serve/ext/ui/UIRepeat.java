/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import java.util.List;
import org.omnifaces.serve.component.ServeComponent;
import org.omnifaces.serve.component.UIComponentBase;

/**
 * The UI component for ui:repeat.
 */
@ServeComponent("org.omnifaces.serve.ext.ui.UIRepeat")
public class UIRepeat extends UIComponentBase {

    /**
     * Get the family.
     *
     * @return the family.
     */
    @Override
    public String getFamily() {
        return "org.omnifaces.serve.ext.ui";
    }

    /**
     * Make sure the returned type is a list.
     *
     * @param value the value.
     * @return the list.
     */
    @SuppressWarnings({"unchecked"})
    public List<Object> toList(Object value) {
        return (List<Object>) value;
    }
}
