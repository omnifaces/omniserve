/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import javax.el.ValueExpression;
import javax.inject.Inject;
import org.omnifaces.serve.phase.PhaseContext;

/**
 * A UI form.
 */
public class UIForm extends UIComponentBase {

    /**
     * Stores the context.
     */
    @Inject
    private PhaseContext context;

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
     * Is submitted.
     *
     * @return true if it is, false otherwise.
     */
    public boolean isSubmitted() {
        boolean result = false;

        if (attributes.containsKey("submitted")) {
            if (attributes.get("submitted") instanceof ValueExpression) {
                ValueExpression ve = (ValueExpression) attributes.get("submitted");
                result = (boolean) ve.getValue(context.getELContext());
            } else {
                result = (boolean) attributes.get("submitted");
            }
        }

        return result;
    }

    /**
     * Set the submitted flag.
     *
     * @param submitted the submitted flag.
     */
    public void setSubmitted(boolean submitted) {
        if (attributes.containsKey("submitted") && attributes.get("submitted") instanceof ValueExpression) {
            ValueExpression ve = (ValueExpression) attributes.get("submitted");
            ve.setValue(context.getELContext(), submitted);
        } else {
            attributes.put("submitted", submitted);
        }
    }
}
