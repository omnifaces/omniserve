/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.validator;

import org.omnifaces.serve.validator.ServeValidator;
import org.omnifaces.serve.validator.ValidatorException;

/**
 * A required validator.
 */
@ServeValidator(value = "org.omnifaces.serve.ext.validator.RequiredValidator")
public class RequiredValidator extends BaseValidator {

    /**
     * Validate the object.
     *
     * @param object the object.
     */
    @Override
    public void validate(Object object) {
        if (!isDisabled() && object == null) {
            throw new ValidatorException("Value is required");
        }
    }
}
