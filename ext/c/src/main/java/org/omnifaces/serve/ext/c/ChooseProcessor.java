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
 * The processor for c:choose.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/c", localName = "choose")
public class ChooseProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        UIPanel choosePanel = createComponent(UIPanel.class,
                "org.omnifaces.serve.component.UIPanel", context, parent, index);

        /*
         * Now determine which of the choices needs to be used.
         */
        Iterator<Processor<ServeProcessorContext, UIComponent>> choices = getChildren().iterator();
        Processor<ServeProcessorContext, UIComponent> choice = null;
        int choiceIndex = 0;
        while (choices.hasNext()) {
            Processor<ServeProcessorContext, UIComponent> processor = choices.next();
            if (processor instanceof WhenProcessor) {
                WhenProcessor whenProcessor = (WhenProcessor) processor;
                String testString = whenProcessor.getAttributes().get("test").getValue();
                boolean test = (Boolean) context.evaluate(testString, Boolean.class);
                if (test) {
                    choice = whenProcessor;
                    break;
                }
            }
            if (processor instanceof OtherwiseProcessor) {
                choice = processor;
                break;
            }
            choiceIndex++;
        }

        if (choice != null) {
            /*
             * If we found a choice lets add it.
             */
            choosePanel.getAttributes().put("choiceIndex", choiceIndex);
            choice.process(context, parent, 0);
        } else {
            /*
             * Else remove the children (no choice was made).
             */
            choosePanel.getAttributes().put("choiceIndex", -1);
            choosePanel.getChildren().clear();
        }
    }
}
