/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import java.util.List;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for cc:insertChildren.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/cc", localName = "insertChildren")
public class InsertChildrenProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        UICompositeComponent container = getClosestParent(parent, UICompositeComponent.class);
        List<UIComponent> insertChildren = container.getChildren().get(0).getChildren();
        parent.getChildren().addAll(insertChildren);
    }
}
