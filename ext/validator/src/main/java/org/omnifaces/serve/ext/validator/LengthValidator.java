/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.validator;

import org.omnifaces.serve.validator.ServeValidator;
import org.omnifaces.serve.validator.ValidatorException;

/**
 * A length validator.
 */
@ServeValidator(value = "org.omnifaces.serve.ext.validator.LengthValidator")
public class LengthValidator extends BaseValidator {

    /**
     * Stores the naximum.
     */
    private Integer maximum;

    /**
     * Stores the minimum.
     */
    private Integer minimum;

    /**
     * Set the maximum.
     *
     * @param maximum the maximum.
     */
    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    /**
     * Set the minimum.
     *
     * @param minimum the minimum.
     */
    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    /**
     * Validate.
     *
     * @param object the object to validate against.
     */
    @Override
    public void validate(Object object) {
        if (!isDisabled() && object != null) {
            String string = object.toString();
            if (!"".equals(string)) {
                if (maximum != null && string.length() > maximum) {
                    throw new ValidatorException(
                            "Length is more than expected maximum: " + maximum.toString());
                }
                if (minimum != null && string.length() < minimum) {
                    throw new ValidatorException(
                            "Length is less than expected minimum: " + minimum.toString());
                }
            }
        }
    }
}
