/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.chartjs;

import org.omnifaces.serve.ext.chartjs.BarChartData;
import org.omnifaces.serve.ext.chartjs.BarChartDataSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * The showcase for f:attributes.
 *
 * 
 */
@Named
@RequestScoped
public class BarChart1Bean {

    /**
     * Get the data.
     *
     * @return the data.
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public BarChartData getData() {
        BarChartData result = new BarChartData();
        List<String> labels = new ArrayList<>(Arrays.asList(
                new String[]{"January", "February", "March", "April", "May", "June", "July"}));
        BarChartDataSet dataset = new BarChartDataSet();
        List<Number> data = new ArrayList<>(Arrays.asList(
                new Integer[]{65, 59, 80, 81, 56, 55, 40}));
        dataset.setData(data);
        dataset.setLabel("My First dataset");
        dataset.setBackgroundColors(Arrays.asList(new String[]{"rgba(255,99,132,0.2)"}));
        dataset.setBorderColors(Arrays.asList(new String[]{"rgba(255,99,132,1)"}));
        dataset.setBorderWidths(Arrays.asList(new Integer[]{1, 1, 1, 1, 1, 1, 1}));
        dataset.setHoverBackgroundColors(Arrays.asList(new String[]{"rgba(255,99,132,0.4)"}));
        dataset.setHoverBorderColors(Arrays.asList(new String[]{"rgba(255,99,132,1)"}));
        List<BarChartDataSet> datasets = new ArrayList<>();
        datasets.add(dataset);
        result.setLabels(labels);
        result.setDatasets(datasets);
        return result;
    }
}
