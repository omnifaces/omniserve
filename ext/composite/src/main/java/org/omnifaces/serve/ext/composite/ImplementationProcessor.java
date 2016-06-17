/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for cc:implementation.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/cc", localName = "implementation")
public class ImplementationProcessor extends ServeTagProcessor {
}
