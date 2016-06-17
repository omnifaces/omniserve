/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIText;
import org.omnifaces.template.StaticTextProcessor;

/**
 * The text processor.
 */
public class TextProcessor extends StaticTextProcessor<ServeProcessorContext, UIComponent> {

    /**
     * Process the text.
     *
     * @param context the context.
     * @param node the node.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent node, int index) {
        UIText text = new UIText();
        text.setText(getText());
        node.getChildren().add(text);
    }
}
