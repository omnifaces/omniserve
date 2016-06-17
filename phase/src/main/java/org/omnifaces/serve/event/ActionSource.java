/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.event;

import javax.el.MethodExpression;

/**
 * An action source.
 */
public interface ActionSource {

    /**
     * Add an action listener.
     *
     * @param actionListener the action listener.
     */
    void addActionListener(ActionListener actionListener);

    /**
     * Get the action expression.
     *
     * @return the action expression.
     */
    MethodExpression getActionExpression();

    /**
     * Set the action expression.
     *
     * @param actionExpression the action expression.
     */
    void setActionExpression(MethodExpression actionExpression);
}
