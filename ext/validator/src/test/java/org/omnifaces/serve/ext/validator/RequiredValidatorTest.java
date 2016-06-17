/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.validator;

import org.junit.Test;
import org.omnifaces.serve.validator.ValidatorException;

/**
 * The JUnit tests for RequiredValidator.
 */
public class RequiredValidatorTest {

    /**
     * Test validate method.
     */
    @Test(expected = ValidatorException.class)
    public void testValidate() {
        RequiredValidator validator = new RequiredValidator();
        validator.validate(null);
    }

    /**
     * Test validate method.
     */
    @Test
    public void testValidat2e() {
        RequiredValidator validator = new RequiredValidator();
        validator.validate("1234");
    }
}
