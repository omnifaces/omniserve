/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.f;

import java.util.Map;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:passThroughAttributes.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/f", localName = "passThroughAttributes")
public class PassThroughAttributesProcessor extends ServeAttachedObjectProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        Map<String, Object> map = (Map<String, Object>) context.evaluate(
                attributes.get("value").getValue(), Map.class);

        map.entrySet().stream().forEach((entry) -> {
            String key = entry.getKey();
            Object value = entry.getValue();
            parent.getPassThroughAttributes().put(key, value);
        });
    }
}
