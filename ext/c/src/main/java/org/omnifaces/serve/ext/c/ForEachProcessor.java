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
 * The processor for c:forEach.
 *
 * <p>
 * A c:forEach will add its body n times to the tree, where n is dependent on
 * its attributes.
 * </p>
 *
 * <p>
 * Note the c:forEach tag is NOT cache-able. If you want caching of the
 * component tree do not use c:forEach.
 * </p>
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/c", localName = "forEach")
public class ForEachProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        UIPanel forEachPanel = createComponent(UIPanel.class,
                "org.omnifaces.serve.component.UIPanel", context, parent, index);

        if (attributes.containsKey("begin")) {
            forEachPanel.getAttributes().put("begin", attributes.get("begin").getValue());
        }
        if (attributes.containsKey("end")) {
            forEachPanel.getAttributes().put("end", attributes.get("end").getValue());
        }

        String beginAttribute = forEachPanel.getAttributes().get("begin").toString();
        String endAttribute = forEachPanel.getAttributes().get("end").toString();
        Integer begin = (Integer) context.evaluate(beginAttribute, Integer.class);
        Integer end = (Integer) context.evaluate(endAttribute, Integer.class);

        for (int i = begin; i < end; i++) {
            Iterator<Processor<ServeProcessorContext, UIComponent>> iterator = getChildren().iterator();
            int j = 0;
            while (iterator.hasNext()) {
                Processor<ServeProcessorContext, UIComponent> childHandler = iterator.next();
                childHandler.process(context, forEachPanel, j);
                j++;
            }
        }
    }
}
