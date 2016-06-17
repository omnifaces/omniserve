/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.action;

import javax.enterprise.context.ApplicationScoped;
import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.lifecycle.Lifecycle;
import org.omnifaces.serve.lifecycle.LifecycleId;

/**
 * The ACTION lifecycle.
 */
@ApplicationScoped
@LifecycleId("ACTION")
public class ActionLifecycle implements Lifecycle {

    /**
     * Execute.
     *
     * @param context the context.
     */
    @Override
    public void execute(Context context) {
    }

    /**
     * Get the context interface.
     *
     * @return the context interface.
     */
    @Override
    public Class getContextInterface() {
        return null;
    }

    /**
     * Get the id.
     *
     * @return the id.
     */
    @Override
    public String getId() {
        return "ACTION";
    }
}
