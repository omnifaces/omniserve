/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

import javax.el.MethodExpression;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.event.ActionEvent;
import org.omnifaces.serve.event.ActionListener;
import org.omnifaces.serve.event.ActionSource;
import org.omnifaces.serve.event.ServeActionListener;
import org.omnifaces.serve.view.ViewHandler;

/**
 * The one-and-only default action listener.
 */
@ApplicationScoped
@ServeActionListener("DEFAULT")
public class DefaultActionListener implements ActionListener {

    /**
     * Stores the view handler.
     */
    @Inject
    private ViewHandler viewHandler;

    /**
     * Stores the context.
     */
    @Inject
    private PhaseContext context;

    /**
     * Process the action.
     *
     * @param event the action event.
     */
    @Override
    public void processAction(ActionEvent event) {
        ActionSource actionSource = (ActionSource) event.getSource();
        MethodExpression actionExpression = actionSource.getActionExpression();
        String result = (String) actionExpression.invoke(context.getELContext(), new Object[]{});
        if (result == null || "".equals(result.trim())) {
            result = context.getViewRoot().getViewId();
        }
        if (!result.equals(context.getViewRoot().getViewId())) {
            UIViewRoot root = viewHandler.createView(context, result);
            context.setViewRoot(root);
            viewHandler.buildView(context);
        }
        context.renderResponse();
    }
}
