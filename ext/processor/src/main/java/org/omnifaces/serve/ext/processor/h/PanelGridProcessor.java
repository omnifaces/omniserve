/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import java.util.Iterator;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlPanelGrid;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.serve.ext.processor.TextProcessor;
import org.omnifaces.template.Processor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:panelGrid.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "panelGrid")
public class PanelGridProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlPanelGrid component = createComponent(HtmlPanelGrid.class,
                "org.omnifaces.serve.component.html.HtmlPanelGrid", context, parent, index);

        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "bgcolor", String.class);
        processValueExpressionAttribute(context, component, "bodyrows", String.class);
        processValueExpressionAttribute(context, component, "border", int.class);
        processValueExpressionAttribute(context, component, "captionClass", String.class);
        processValueExpressionAttribute(context, component, "captionStyle", String.class);
        processValueExpressionAttribute(context, component, "cellpadding", String.class);
        processValueExpressionAttribute(context, component, "cellspacing", String.class);
        processValueExpressionAttribute(context, component, "columnClasses", String.class);
        processValueExpressionAttribute(context, component, "columns", int.class);
        processValueExpressionAttribute(context, component, "dir", String.class);
        processValueExpressionAttribute(context, component, "footerClass", String.class);
        processValueExpressionAttribute(context, component, "frame", String.class);
        processValueExpressionAttribute(context, component, "headerClass", String.class);
        processValueExpressionAttribute(context, component, "lang", String.class);
        processEventAttributes(context, parent);
        processValueExpressionAttribute(context, component, "role", String.class);
        processValueExpressionAttribute(context, component, "rowClasses", String.class);
        processValueExpressionAttribute(context, component, "rules", String.class);
        processValueExpressionAttribute(context, component, "style", String.class);
        processValueExpressionAttribute(context, component, "styleClass", String.class);
        processValueExpressionAttribute(context, component, "summary", String.class);
        processValueExpressionAttribute(context, component, "title", String.class);
        processValueExpressionAttribute(context, component, "width", String.class);
        processPassthroughAttributes(context, component);

        Iterator<Processor<ServeProcessorContext, UIComponent>> iterator = children.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Processor<ServeProcessorContext, UIComponent> processor = iterator.next();
            if (!(processor instanceof TextProcessor)) {
                processor.process(context, component, i);

                if (!context.isProcessing()) {
                    break;
                }

                /*
                 * If we are not processing an attached object processor we are
                 * expecting it to add a UIComponent to the tree, otherwise we
                 * expect it to add nothing.
                 */
                if (!(processor instanceof ServeAttachedObjectProcessor)) {
                    i++;
                }
            }
        }
    }
}
