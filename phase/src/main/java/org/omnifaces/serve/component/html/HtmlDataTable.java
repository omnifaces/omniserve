/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import java.util.List;
import org.omnifaces.serve.component.ServeComponent;
import org.omnifaces.serve.component.UIComponentBase;

/**
 * A HTML command link.
 */
@ServeComponent("org.omnifaces.serve.component.html.HtmlDataTable")
public class HtmlDataTable extends UIComponentBase {

    /**
     * Get the family.
     *
     * @return the family.
     */
    @Override
    public String getFamily() {
        return "org.omnifaces.serve.component.html";
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
