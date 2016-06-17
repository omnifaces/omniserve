/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.validator;

import org.omnifaces.serve.validator.Validator;
import org.omnifaces.serve.validator.ValidatorException;

/**
 * A double range validator.
 */
public class DoubleRangeValidator implements Validator {

    /**
     * Stores the minimum.
     */
    private Double minimum;

    /**
     * Stores the maximum.
     */
    private Double maximum;

    /**
     * Set the maximum.
     *
     * @param maximum the maximum.
     */
    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }

    /**
     * Set the minimum.
     *
     * @param minimum the minimum.
     */
    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    /**
     * Validate.
     *
     * @param object the object to validate against.
     */
    @Override
    public void validate(Object object) {
        if (object != null) {
            Double toValidate = (Double) object;
            if (minimum != null && toValidate.compareTo(minimum) < 0) {
                throw new ValidatorException(
                        "Value is less than expected minimum: " + minimum.toString());
            }
            if (maximum != null && toValidate.compareTo(maximum) > 0) {
                throw new ValidatorException(
                        "Value is more than expected maximum: " + maximum.toString());
            }
        }
    }
}
