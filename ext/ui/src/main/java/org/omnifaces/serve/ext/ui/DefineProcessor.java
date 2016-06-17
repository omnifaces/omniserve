/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import java.util.List;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIPanel;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for ui:define.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/ui", localName = "define")
public class DefineProcessor extends ServeTagProcessor {

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
        UIPanel panel = new UIPanel();
        parent.getChildren().add(panel);

        String name = InsertProcessor.class.getName() + "_" + attributes.get("name").getValue();
        List<UIInsert> insertPoints = (List<UIInsert>) context.getAttribute(name);

        if (insertPoints != null) {
            insertPoints.stream().forEach((insertPoint) -> {
                super.process(context, insertPoint, 0);
            });
        }
    }
}
