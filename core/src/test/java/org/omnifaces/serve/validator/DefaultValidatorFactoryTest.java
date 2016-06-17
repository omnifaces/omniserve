/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.validator;

import javax.enterprise.inject.spi.CDI;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 * The JUnit tests for DefaultValidatorFactory.
 */
public class DefaultValidatorFactoryTest {

    /**
     * Stores the container.
     */
    WeldContainer container;

    /**
     * Stores the weld.
     */
    Weld weld;

    /**
     * Setup before testing.
     */
    @Before
    public void setUp() {
        weld = new Weld();
        container = weld.initialize();
    }

    /**
     * Tear down after testing.
     */
    @After
    public void tearDown() {
        weld.shutdown();
    }

    /**
     * Test createConverter method.
     */
    @Test
    public void testCreateConverter() {
        ValidatorFactory factory = (ValidatorFactory) CDI.current().select(ValidatorFactory.class).get();
        assertNotNull(factory.createValidator("org.omnifaces.serve.validator.MethodExpressionValidator"));
    }
}
