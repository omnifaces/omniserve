/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

import java.util.Iterator;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import org.omnifaces.serve.event.ActionEvent;
import org.omnifaces.serve.event.ActionListener;
import org.omnifaces.serve.event.Event;

/**
 * The "INVOKE_APPLICATION" phase.
 */
@ApplicationScoped
@Default
@ServePhaseId("INVOKE_APPLICATION")
public class InvokeApplicationPhase extends BasePhase {

    /**
     * Execute the phase.
     *
     * @param context the context.
     */
    @Override
    public void execute(PhaseContext context) {
        context.setCurrentPhaseId(getId());
        if (!shouldSkip(context)) {
            Iterator<Event> events = context.getEvents(getId()).iterator();
            while (events.hasNext()) {
                ActionEvent event = (ActionEvent) events.next();
                ActionListener listener = (ActionListener) event.getSource();
                if (listener != null) {
                    listener.processAction(event);
                }
            }
        }
    }

    @Override
    public PhaseId getId() {
        return PhaseId.INVOKE_APPLICATION;
    }
}
