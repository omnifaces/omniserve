/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.chartjs;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The data model for chartjs:barChart.
 */
@XmlRootElement(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class BarChartData {

    /**
     * Stores the datasets.
     */
    @XmlElement(name = "datasets")
    private List<BarChartDataSet> datasets;
    /**
     * Stores the labels.
     */
    @XmlElement(name = "labels")
    private List<String> labels;

    /**
     * Get the datasets.
     *
     * @return the datasets.
     */
    public List<BarChartDataSet> getDatasets() {
        return datasets;
    }

    /**
     * Get the labels.
     *
     * @return the labels.
     */
    public List<String> getLabels() {
        return labels;
    }

    /**
     * Set the datasets.
     *
     * @param datasets the datasets.
     */
    public void setDatasets(List<BarChartDataSet> datasets) {
        this.datasets = datasets;
    }

    /**
     * Set the labels.
     *
     * @param labels the labels.
     */
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
