/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.validator;

import java.util.regex.Pattern;
import org.omnifaces.serve.validator.ServeValidator;
import org.omnifaces.serve.validator.ValidatorException;

/**
 * A regular expression validator.
 */
@ServeValidator(value = "org.omnifaces.serve.ext.validator.RegexValidator")
public class RegexValidator extends BaseValidator {

    /**
     * Stores the pattern.
     */
    private String pattern;

    /**
     * Set the pattern.
     *
     * @param pattern the pattern.
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
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
            if (!Pattern.matches(pattern, string)) {
                throw new ValidatorException("Unable to match pattern: " + pattern);
            }
        }
    }
}
