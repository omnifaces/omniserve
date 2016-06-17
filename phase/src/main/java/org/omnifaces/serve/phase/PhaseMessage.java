/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

/**
 * A message.
 */
public class PhaseMessage {

    /**
     * Stores the summary.
     */
    private String summary;

    /**
     * Constructor.
     *
     * @param summary the summary.
     */
    public PhaseMessage(String summary) {
        this.summary = summary;
    }

    /**
     * Get the summary.
     *
     * @return the summary.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Set the summary.
     *
     * @param summary the summary.
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }
}
