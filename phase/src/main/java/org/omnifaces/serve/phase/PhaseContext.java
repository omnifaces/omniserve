/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

import java.util.List;
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.event.Event;
import org.omnifaces.serve.renderkit.RenderKit;
import org.omnifaces.serve.renderkit.ResponseWriter;

/**
 * A phase context.
 */
public interface PhaseContext extends Context {

    /**
     * Add the event to the event queue.
     *
     * @param event the event.
     */
    void addEvent(Event event);

    /**
     * Add the message.
     *
     * @param id the id.
     * @param message the message.
     */
    void addMessage(String id, PhaseMessage message);

    /**
     * Get the current phase id.
     *
     * @return the phase id.
     */
    PhaseId getCurrentPhaseId();

    /**
     * Get the events.
     *
     * @param phaseId the phase id.
     * @return the events.
     */
    List<Event> getEvents(PhaseId phaseId);

    /**
     * Get the message list.
     *
     * @return the message list.
     */
    List<PhaseMessage> getMessageList();

    /**
     * Get the message list.
     *
     * @param id the id.
     * @return the list of message, or null.
     */
    List<PhaseMessage> getMessageList(String id);

    /**
     * Get the render kit.
     *
     * @return the render kit.
     */
    RenderKit getRenderKit();

    /**
     * Get the render response flag.
     *
     * @return the render response flag.
     */
    boolean getRenderResponse();

    /**
     * Get the response complete flag.
     *
     * @return the response complete flag.
     */
    boolean getResponseComplete();

    /**
     * Get the response writer.
     *
     * @return the response writer.
     */
    ResponseWriter getResponseWriter();

    /**
     * Get the view root.
     *
     * @return the view root.
     */
    UIViewRoot getViewRoot();

    /**
     * Is this a post back?
     *
     * @return true if it is, false otherwise.
     */
    boolean isPostback();

    /**
     * Render the response.
     */
    void renderResponse();

    /**
     * Set the current phase id.
     *
     * @param phaseId the phase id.
     */
    void setCurrentPhaseId(PhaseId phaseId);

    /**
     * Set the render kit.
     *
     * @param renderKit the render kit.
     */
    void setRenderKit(RenderKit renderKit);

    /**
     * Set the response writer.
     *
     * @param writer the response writer.
     */
    void setResponseWriter(ResponseWriter writer);

    /**
     * Set the view root.
     *
     * @param viewRoot the view root.
     */
    void setViewRoot(UIViewRoot viewRoot);
}
