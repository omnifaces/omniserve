/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import java.util.ArrayList;
import java.util.List;
import javax.el.MethodExpression;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import org.omnifaces.serve.event.ActionEvent;
import org.omnifaces.serve.event.ActionListener;
import org.omnifaces.serve.event.ActionSource;
import org.omnifaces.serve.event.ServeActionListener;

/**
 * An UI command.
 */
@Alternative
public class UICommand extends UIComponentBase implements ActionSource, ActionListener {

    /**
     * Stores our action listeners.
     */
    private final List<ActionListener> actionListeners;

    /**
     * Stores the default action listener.
     */
    @Inject
    @ServeActionListener("DEFAULT")
    private ActionListener defaultActionListener;

    /**
     * Constructor.
     */
    public UICommand() {
        super();
        actionListeners = new ArrayList<>(1);
    }

    /**
     * Add the action listener.
     *
     * @param actionListener the action listener.
     */
    @Override
    public void addActionListener(ActionListener actionListener) {
        this.actionListeners.add(actionListener);
    }

    /**
     * Get the action expression.
     *
     * @return the action expression.
     */
    @Override
    public MethodExpression getActionExpression() {
        return (MethodExpression) getAttributes().get("actionExpression");
    }

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
     * Set the action expression.
     *
     * @param actionExpression the action expression.
     */
    @Override
    public void setActionExpression(MethodExpression actionExpression) {
        getAttributes().put("actionExpression", actionExpression);
    }

    /**
     * Process the action event.
     *
     * @param actionEvent the action event.
     */
    @Override
    public void processAction(ActionEvent actionEvent) {
        actionListeners.stream().forEach((actionListener) -> {
            actionListener.processAction(actionEvent);
        });
        defaultActionListener.processAction(actionEvent);
    }
}
