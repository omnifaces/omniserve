/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The HTML renderer for ui:insert.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.ext.ui",
        rendererType = "org.omnifaces.serve.ext.ui.UIInsert")
public class UIInsertRenderer extends BaseRenderer {
}
