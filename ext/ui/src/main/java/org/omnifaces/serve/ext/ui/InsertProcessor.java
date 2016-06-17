/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import java.util.ArrayList;
import java.util.List;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for ui:insert.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/ui", localName = "insert")
public class InsertProcessor extends ServeTagProcessor {

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
        UIInsert insertPanel = new UIInsert();
        parent.getChildren().add(insertPanel);

        String name = InsertProcessor.class.getName() + "_" + attributes.get("name").getValue();
        List<UIInsert> insertPoints = (List<UIInsert>) context.getAttribute(name);
        if (insertPoints == null) {
            insertPoints = new ArrayList<>();
        }

        insertPoints.add(insertPanel);
        context.setAttribute(name, insertPoints);
    }
}
