/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.validator;

import org.omnifaces.serve.validator.ServeValidator;
import org.omnifaces.serve.validator.ValidatorException;

/**
 * A long range validator.
 */
@ServeValidator(value = "org.omnifaces.serve.ext.validator.LongRangeValidator")
public class LongRangeValidator extends BaseValidator {

    /**
     * Stores the minimum.
     */
    private Long minimum;

    /**
     * Stores the maximum.
     */
    private Long maximum;

    /**
     * Set the maximum.
     *
     * @param maximum the maximum.
     */
    public void setMaximum(Long maximum) {
        this.maximum = maximum;
    }

    /**
     * Set the minimum.
     *
     * @param minimum the minimum.
     */
    public void setMinimum(Long minimum) {
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
            Long toValidate = (Long) object;
            if (minimum != null && toValidate < minimum) {
                throw new ValidatorException(
                        "Value is less than expected minimum: " + minimum.toString());
            }
            if (maximum != null && toValidate > maximum) {
                throw new ValidatorException(
                        "Value is more than expected maximum: " + maximum.toString());
            }
        }
    }
}
