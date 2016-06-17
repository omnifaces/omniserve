/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlOutputScript;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:outputScript.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "outputScript")
public class OutputScriptProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlOutputScript outputScript = createComponent(HtmlOutputScript.class,
                "org.omnifaces.serve.component.html.HtmlOutputScript", context, parent, index);

        processValueExpressionAttribute(context, outputScript, "library", String.class);
        processValueExpressionAttribute(context, outputScript, "id", String.class);
        processValueExpressionAttribute(context, outputScript, "name", String.class);
        processPassthroughAttributes(context, outputScript);

        super.process(context, outputScript, 0);
    }
}
