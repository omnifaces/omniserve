/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.validator;

import org.omnifaces.serve.validator.Validator;

/**
 * A bean validator.
 */
public class BeanPropertyValidator implements Validator {

    /**
     * Set the validation groups.
     *
     * @param validationGroups the validation groups.
     */
    public void setValidationGroups(String validationGroups) {
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
