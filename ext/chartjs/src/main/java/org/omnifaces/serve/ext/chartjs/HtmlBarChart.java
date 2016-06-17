/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.chartjs;

import org.omnifaces.serve.component.ServeComponent;
import org.omnifaces.serve.component.UIOutput;

/**
 * The component for chartjs:barChart.
 */
@ServeComponent(value = "org.omnifaces.serve.ext.chartjs.HtmlBarChart")
public class HtmlBarChart extends UIOutput {

    /**
     * Get the family.
     *
     * @return the family.
     */
    @Override
    public String getFamily() {
        return "org.omnifaces.serve.ext.chartjs";
    }
}
