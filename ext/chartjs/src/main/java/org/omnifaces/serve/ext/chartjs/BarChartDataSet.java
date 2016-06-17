/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.chartjs;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The dataset model for chartjs:barChart.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BarChartDataSet {

    /**
     * Stores the background color(s).
     */
    @XmlElement(name = "backgroundColor")
    @XmlList
    private List<String> backgroundColors;

    /**
     * Stores the border color(s).
     */
    @XmlElement(name = "borderColor")
    @XmlList
    private List<String> borderColors;

    /**
     * Stores the border skipped(s).
     */
    @XmlElement(name = "borderSkipped")
    @XmlList
    private List<String> borderSkippeds;

    /**
     * Stores the border width(s).
     */
    @XmlElement(name = "borderWidth")
    private List<Number> borderWidths;

    /**
     * Stores the list of numbers.
     */
    @XmlElement(name = "data")
    private List<Number> data;

    /**
     * Stores the hover background color(s).
     */
    @XmlElement(name = "hoverBackgroundColor")
    @XmlList
    private List<String> hoverBackgroundColors;

    /**
     * Stores the hover border color(s).
     */
    @XmlElement(name = "hoverBorderColor")
    @XmlList
    private List<String> hoverBorderColors;

    /**
     * Stores the hover border width(s).
     */
    @XmlElement(name = "hoverBorderWidth")
    private List<Number> hoverBorderWidths;

    /**
     * Stores the label.
     */
    @XmlElement(name = "label")
    private String label;

    /**
     * Stores the xAxisID.
     */
    @XmlElement(name = "xAxisID")
    private String xAxisID;

    /**
     * Stores the yAxisID.
     */
    @XmlElement(name = "yAxisID")
    private String yAxisID;

    /**
     * Get the background colors.
     *
     * @return the background colors.
     */
    public List<String> getBackgroundColors() {
        return backgroundColors;
    }

    /**
     * Get the border color(s).
     *
     * @return the border color(s)
     */
    public List<String> getBorderColors() {
        return borderColors;
    }

    /**
     * Get the border skipped(s).
     *
     * @return the border skipped(s).
     */
    public List<String> getBorderSkippeds() {
        return borderSkippeds;
    }

    /**
     * Get the border width(s).
     *
     * @return the border width(s).
     */
    public List<Number> getBorderWidths() {
        return borderWidths;
    }

    /**
     * Get the list of numbers.
     *
     * @return the list of numbers.
     */
    public List<Number> getData() {
        return data;
    }

    /**
     * Get the hover background color(s).
     *
     * @return the hover background color(s).
     */
    public List<String> getHoverBackgroundColors() {
        return hoverBackgroundColors;
    }

    /**
     * Get the hover border color(s).
     *
     * @return the hover border color(s).
     */
    public List<String> getHoverBorderColors() {
        return hoverBorderColors;
    }

    /**
     * Get the hover border widths.
     *
     * @return the hover border widths.
     */
    public List<Number> getHoverBorderWidths() {
        return hoverBorderWidths;
    }

    /**
     * Get the label.
     *
     * @return the label.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Get the xAxisID.
     *
     * @return the xAxisID.
     */
    public String getXAxisID() {
        return xAxisID;
    }

    /**
     * Get the yAxisID.
     *
     * @return the yAxisID.
     */
    public String getYAxisID() {
        return yAxisID;
    }

    /**
     * Set the background colors.
     *
     * @param backgroundColors the background colors.
     */
    public void setBackgroundColors(List<String> backgroundColors) {
        this.backgroundColors = backgroundColors;
    }

    /**
     * Set the border colors.
     *
     * @param borderColors the border colors.
     */
    public void setBorderColors(List<String> borderColors) {
        this.borderColors = borderColors;
    }

    /**
     * Set the border skipped(s).
     *
     * @param borderSkippeds the border skipped(s).
     */
    public void setBorderSkippeds(List<String> borderSkippeds) {
        this.borderSkippeds = borderSkippeds;
    }

    /**
     * Set the border width(s).
     *
     * @param borderWidths the border width(s).
     */
    public void setBorderWidths(List<Number> borderWidths) {
        this.borderWidths = borderWidths;
    }

    /**
     * Set the list of numbers.
     *
     * @param data the list of numbers.
     */
    public void setData(List<Number> data) {
        this.data = data;
    }

    /**
     * Set the hover background colors.
     *
     * @param hoverBackgroundColors the hover background colors.
     */
    public void setHoverBackgroundColors(List<String> hoverBackgroundColors) {
        this.hoverBackgroundColors = hoverBackgroundColors;
    }

    /**
     * Set the hover border colors.
     *
     * @param hoverBorderColors the hover border colors.
     */
    public void setHoverBorderColors(List<String> hoverBorderColors) {
        this.hoverBorderColors = hoverBorderColors;
    }

    /**
     * Set the hover border width(s).
     *
     * @param hoverBorderWidths the hover border width(s).
     */
    public void setHoverBorderWidths(List<Number> hoverBorderWidths) {
        this.hoverBorderWidths = hoverBorderWidths;
    }

    /**
     * Set the label.
     *
     * @param label the label.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Set the xAxisID.
     *
     * @param xAxisID the xAxisID.
     */
    @SuppressWarnings("checkstyle:hiddenfield")
    public void setXAxisID(String xAxisID) {
        this.xAxisID = xAxisID;
    }

    /**
     * Set the yAxisID.
     *
     * @param yAxisID the yAxisID.
     */
    @SuppressWarnings("checkstyle:hiddenfield")
    public void setYAxisID(String yAxisID) {
        this.yAxisID = yAxisID;
    }
}
