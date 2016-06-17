/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.event;

/**
 * An action event.
 */
public class ActionEvent extends Event {

    /**
     * Constructor.
     *
     * @param actionSource the source of the action.
     */
    public ActionEvent(ActionSource actionSource) {
        super(actionSource);
    }
}
