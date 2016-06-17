/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.spi.CDI;
import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.UnboundLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIPanel;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TagAttribute;

/**
 * The JUnit tests for ParamProcessor.
 */
public class ParamProcessorTest {

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
        RequestContext requestContext = CDI.current().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
        requestContext.activate();

        ServeProcessorContext context = (ServeProcessorContext) CDI.current().select(ServeProcessorContext.class).get();
        ParamProcessor processor = new ParamProcessor();
        Map<String, TagAttribute> attributes = new HashMap<>();
        TagAttribute nameAttribute = new TagAttribute("", "name", "name");
        TagAttribute valueAttribute = new TagAttribute("", "value", "value");
        attributes.put("name", nameAttribute);
        attributes.put("value", valueAttribute);
        processor.setAttributes(attributes);
        UIComponent parent = new UIPanel();
        processor.process(context, parent, 0);
        assertNotNull(context.getVariableMapper().resolveVariable("name"));

        requestContext.deactivate();
    }
}
