/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import javax.enterprise.inject.spi.CDI;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIPanel;
import org.omnifaces.serve.component.html.HtmlGraphicImage;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;

/**
 * The JUnit tests for GraphicImageProcessor.
 */
public class GraphicImageProcessorTest {

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
        GraphicImageProcessor processor = new GraphicImageProcessor();
        UIComponent parent = new UIPanel();
        processor.process(context, parent, 0);
        assertTrue(parent.getChildren().get(0) instanceof HtmlGraphicImage);
    }
}
