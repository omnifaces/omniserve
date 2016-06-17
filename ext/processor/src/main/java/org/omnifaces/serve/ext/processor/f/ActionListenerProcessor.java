/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.f;

import javax.inject.Inject;
import org.omnifaces.serve.cdi.CdiManager;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.event.ActionListener;
import org.omnifaces.serve.event.ActionSource;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:actionListener.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/f", localName = "actionListener")
public class ActionListenerProcessor extends ServeAttachedObjectProcessor {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    // TODO support for attribute.
    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        if (parent instanceof ActionSource) {
            ActionSource actionSource = (ActionSource) parent;
            try {
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                Class<?> clazz = Class.forName(attributes.get("type").getValue(), true, classLoader);
                ActionListener actionListener;
                if (cdiManager.exists(clazz)) {
                    actionListener = (ActionListener) cdiManager.getInstance(clazz);
                } else {
                    actionListener = (ActionListener) clazz.newInstance();
                }
                actionSource.addActionListener(actionListener);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
