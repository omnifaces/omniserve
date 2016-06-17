/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.c;

import java.util.Iterator;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIPanel;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.Processor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for c:if.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/c", localName = "if")
public class IfProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        UIPanel ifPanel = createComponent(UIPanel.class,
                "org.omnifaces.serve.component.UIPanel", context, parent, index);

        ifPanel.getAttributes().put("test", attributes.get("test").getValue());
        String ifString = ifPanel.getAttributes().get("test").toString();
        boolean ifValue = (Boolean) context.evaluate(ifString, boolean.class);

        if (ifValue) {
            Iterator<Processor<ServeProcessorContext, UIComponent>> iterator = getChildren().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Processor<ServeProcessorContext, UIComponent> childHandler = iterator.next();
                childHandler.process(context, ifPanel, i);
                i++;
            }
        }
    }
}
