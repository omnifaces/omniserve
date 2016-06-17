/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.event;

/**
 * An action listener.
 */
public interface ActionListener extends EventListener {

    /**
     * Process the action.
     *
     * @param actionEvent the action event.
     */
    void processAction(ActionEvent actionEvent);
}
