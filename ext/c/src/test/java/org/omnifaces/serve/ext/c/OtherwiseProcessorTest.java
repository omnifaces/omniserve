/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.c;

import org.omnifaces.serve.ext.c.OtherwiseProcessor;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIPanel;
import javax.enterprise.inject.spi.CDI;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;

/**
 * The JUnit tests for OtherwiseProcessor.
 *
 * 
 */
public class OtherwiseProcessorTest {

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
     * Test process method.
     */
    @Test
    public void testProcess() {
        ServeProcessorContext context = (ServeProcessorContext) CDI.current().select(ServeProcessorContext.class).get();
        OtherwiseProcessor processor = new OtherwiseProcessor();
        UIComponent parent = new UIPanel();
        processor.process(context, parent, 0);
        assertTrue(parent.getChildren().isEmpty());
    }
}
