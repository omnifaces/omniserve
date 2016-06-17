/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.validator;

/**
 * The validator factory.
 */
public interface ValidatorFactory {

    /**
     * Create the validator.
     *
     * @param validatorId the validator id.
     * @return the validator.
     */
    Validator createValidator(String validatorId);
}
