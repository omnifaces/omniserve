/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * The JUnit tests for RootProcessor.
 */
public class RootProcessorTest {

    /**
     * Test constructor.
     */
    @Test
    public void testConstructor() {
        RootProcessor processor = new RootProcessor();
        assertNotNull(processor);
    }
}
