/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import org.omnifaces.serve.validator.Validator;
import org.omnifaces.serve.validator.ValidatorException;
import javax.enterprise.context.ApplicationScoped;
import org.omnifaces.serve.validator.ServeValidator;

/**
 * A validator for the f:validator showcase #1.
 *
 * 
 */
@ApplicationScoped
@ServeValidator(value = "validator1Validator")
public class Validator1Validator implements Validator {

    /**
     * Validate the object.
     *
     * @param object the object.
     */
    @Override
    public void validate(Object object) {
        String name = (String) object;
        if (name != null && !name.equals("Duke")) {
            throw new ValidatorException("You did not enter \'Duke\'");
        }
    }
}
