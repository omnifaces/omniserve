/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.f;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import org.omnifaces.serve.event.ActionEvent;
import org.omnifaces.serve.event.ActionListener;
import org.omnifaces.serve.event.ServeActionListener;
import org.omnifaces.serve.phase.PhaseContext;

/**
 * The ActionListener backing the f:setPropertyActionListener tag.
 */
@ServeActionListener("SET_PROPERTY_ACTION")
@Dependent
public class SetPropertyActionListener implements ActionListener, Serializable {

    /**
     * Stores the serial version UID.
     */
    private static final long serialVersionUID = 3837534148038122260L;

    /**
     * Stores the context.
     */
    @Inject
    @SuppressFBWarnings(justification = "Not a bug", value = "SE_BAD_FIELD")
    private PhaseContext context;

    /**
     * Stores the value VE.
     */
    private ValueExpression value;

    /**
     * Stores the target VE.
     */
    private ValueExpression target;

    /**
     * Process the action.
     *
     * @param actionEvent the action event.
     */
    @Override
    public void processAction(ActionEvent actionEvent) {
        ELContext elContext = context.getELContext();
        Object object = value.getValue(elContext);
        target.setValue(elContext, object);
    }

    /**
     * Set the target.
     *
     * @param target the target.
     */
    public void setTarget(ValueExpression target) {
        this.target = target;
    }

    /**
     * Set the value.
     *
     * @param value the value.
     */
    public void setValue(ValueExpression value) {
        this.value = value;
    }
}
