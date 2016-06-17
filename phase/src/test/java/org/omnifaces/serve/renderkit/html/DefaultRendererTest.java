/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.io.StringWriter;
import javax.enterprise.inject.spi.CDI;
import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.UnboundLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.phase.PhaseContext;

/**
 * The JUnit tests for DefaultRenderer.
 */
public class DefaultRendererTest {

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
     * Test encode method.
     */
    @Test
    public void testEncode() {
        RequestContext requestContext = CDI.current().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
        requestContext.activate();

        PhaseContext context = CDI.current().select(PhaseContext.class).get();
        StringWriter stringWriter = new StringWriter();
        context.setResponseWriter(new HtmlResponseWriter(stringWriter));
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.encode(context, new UIViewRoot());

        assertEquals(" *** Unable to find renderer for component: class org.omnifaces.serve.component.UIViewRoot *** ", stringWriter.toString());

        requestContext.deactivate();
    }
}
