/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.validator;

import javax.el.MethodExpression;

/**
 * A method expression validator.
 */
@ServeValidator("org.omnifaces.serve.validator.MethodExpressionValidator")
public class MethodExpressionValidator implements Validator {

    /**
     * Constructor.
     */
    public MethodExpressionValidator() {
    }

    /**
     * Set the method expression.
     *
     * @param methodExpression the method expression.
     */
    public void setMethodExpression(MethodExpression methodExpression) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Validate.
     *
     * @param object the object to validate.
     */
    @Override
    public void validate(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
