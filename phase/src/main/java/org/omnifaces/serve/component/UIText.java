/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

/**
 * The text component.
 */
public class UIText extends UIComponentBase {

    /**
     * Get the family.
     *
     * @return the family.
     */
    @Override
    public String getFamily() {
        return "org.omnifaces.serve.component";
    }

    /**
     * Get the text.
     *
     * @return the text.
     */
    public String getText() {
        return (String) attributes.get("text");
    }

    /**
     * Set the text.
     *
     * @param text the text.
     */
    public void setText(String text) {
        this.attributes.put("text", text);
    }
}
