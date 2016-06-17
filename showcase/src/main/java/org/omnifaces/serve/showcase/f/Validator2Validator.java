/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.validator.Validator;
import org.omnifaces.serve.validator.ValidatorException;
import javax.el.ValueExpression;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.omnifaces.serve.validator.ServeValidator;

/**
 * A validator for the f:validator showcase #2.
 *
 * 
 */
@ApplicationScoped
@ServeValidator(value = "validator2Validator")
public class Validator2Validator implements Validator {

    /**
     * Stores the context.
     */
    @Inject
    private Context context;

    /**
     * Stores the disabled flag.
     */
    private boolean disabled = true;

    /**
     * Is disabled.
     *
     * @return true when disabled, false otherwise.
     */
    @Override
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * Set the disabled flag.
     *
     * @param disabled the disabled flag.
     */
    @Override
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * Set the value expression.
     *
     * @param attributeName the attribute name.
     * @param valueExpression the value expression.
     */
    @Override
    public void setValueExpression(String attributeName, ValueExpression valueExpression) {
        if (attributeName.equals("disabled")) {
            disabled = (boolean) valueExpression.getValue(context.getELContext());
        }
    }

    /**
     * Validate the object.
     *
     * @param object the object.
     */
    @Override
    public void validate(Object object) {
        if (!isDisabled()) {
            String name = (String) object;
            if (name != null && !name.equals("Duke")) {
                throw new ValidatorException("You did not enter \'Duke\'");
            }
        }
    }
}
