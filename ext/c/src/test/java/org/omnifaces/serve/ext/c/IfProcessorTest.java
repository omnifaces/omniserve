/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.c;

import org.omnifaces.serve.ext.c.IfProcessor;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIPanel;
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.ext.processor.TextProcessor;
import java.util.HashMap;
import javax.enterprise.inject.spi.CDI;
import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.UnboundLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.omnifaces.template.TagAttribute;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;

/**
 * The JUnit tests for IfProcessor.
 *
 * 
 */
public class IfProcessorTest {

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
        IfProcessor processor = new IfProcessor();
        HashMap<String, TagAttribute> attributes = new HashMap<>();
        attributes.put("test", new TagAttribute("", "test", "false"));
        processor.setAttributes(attributes);
        UIComponent parent = new UIPanel();
        processor.process(context, parent, 0);
        assertTrue(!parent.getChildren().isEmpty());

        requestContext.deactivate();
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess2() {
        RequestContext requestContext = CDI.current().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
        requestContext.activate();

        ServeProcessorContext context = (ServeProcessorContext) CDI.current().select(ServeProcessorContext.class).get();
        IfProcessor processor = new IfProcessor();
        HashMap<String, TagAttribute> attributes = new HashMap<>();
        attributes.put("test", new TagAttribute("", "test", "true"));
        processor.setAttributes(attributes);
        UIComponent parent = new UIPanel();
        processor.process(context, parent, 0);
        assertTrue(!parent.getChildren().isEmpty());

        requestContext.deactivate();
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess5() {
        RequestContext requestContext = CDI.current().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
        requestContext.activate();

        UIViewRoot viewRoot = new UIViewRoot();
        ServeProcessorContext context = (ServeProcessorContext) CDI.current().select(ServeProcessorContext.class).get();
        context.getContext().setViewRoot(viewRoot);
        IfProcessor processor = new IfProcessor();
        TextProcessor staticTextProcessor = new TextProcessor();
        staticTextProcessor.setText("1234");
        processor.getChildren().add(staticTextProcessor);
        staticTextProcessor.setParent(processor);
        HashMap<String, TagAttribute> attributes = new HashMap<>();
        attributes.put("test", new TagAttribute("", "test", "true"));
        processor.setAttributes(attributes);
        UIComponent parent = new UIPanel();
        parent.getChildren().add(new UIPanel());
        processor.process(context, parent, 0);
        assertTrue(!parent.getChildren().isEmpty());

        requestContext.deactivate();
    }
}
