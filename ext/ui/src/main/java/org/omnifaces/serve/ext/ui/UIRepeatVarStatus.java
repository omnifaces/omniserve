/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

/**
 * A POJO to store the varStatus for a ui:repeat.
 */
public class UIRepeatVarStatus {

    /**
     * Stores the index.
     */
    private int index;

    /**
     * Get the index.
     *
     * @return the index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Set the index.
     *
     * @param index the index.
     */
    public void setIndex(int index) {
        this.index = index;
    }
}
