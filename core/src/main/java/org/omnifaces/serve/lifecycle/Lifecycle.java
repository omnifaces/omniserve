/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.lifecycle;

import org.omnifaces.serve.context.Context;

/**
 * The interface for a life-cycle.
 */
public interface Lifecycle {

    /**
     * Execute the life-cycle.
     *
     * @param context the context.
     */
    void execute(Context context);

    /**
     * Get the context interface.
     *
     * @return the context interface.
     */
    Class getContextInterface();

    /**
     * Get the id.
     *
     * @return the id.
     */
    String getId();
}
