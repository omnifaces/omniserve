/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.context.DefaultContext;
import org.omnifaces.serve.event.Event;
import org.omnifaces.serve.renderkit.RenderKit;
import org.omnifaces.serve.renderkit.ResponseWriter;

/**
 * The default PhaseContext.
 */
@RequestScoped
public class DefaultPhaseContext extends DefaultContext implements PhaseContext {

    /**
     * Stores the (queued) events.
     */
    private final List<Event> events = new ArrayList<>();

    /**
     * Stores the phase id.
     */
    private PhaseId currentPhaseId;

    /**
     * Stores the messages map.
     */
    private final Map<String, List<PhaseMessage>> messagesMap = new HashMap<>();

    /**
     * Stores the postback flag.
     */
    private Boolean postback;

    /**
     * Stores the render kit.
     */
    private RenderKit renderKit;

    /**
     * Stores the render response flag.
     */
    private boolean renderResponse;

    /**
     * Stores the response writer.
     */
    private ResponseWriter responseWriter;

    /**
     * Stores the view root.
     */
    private UIViewRoot viewRoot;

    /**
     * Add the event to the event queue.
     *
     * @param event the event.
     */
    @Override
    public void addEvent(Event event) {
        events.add(event);
    }

    /**
     * Add the message.
     *
     * @param id the id.
     * @param message the message.
     */
    @Override
    public void addMessage(String id, PhaseMessage message) {
        List<PhaseMessage> messages = (List) messagesMap.get(id);
        if (messages == null) {
            messages = new ArrayList<>();
            messagesMap.put(id, messages);
        }
        messages.add(message);
    }

    /**
     * Get the current phase id.
     *
     * @return the current phase id.
     */
    @Override
    public PhaseId getCurrentPhaseId() {
        return currentPhaseId;
    }

    /**
     * Get the events.
     *
     * @param phaseId the phase id.
     * @return the events.
     */
    @Override
    public List<Event> getEvents(PhaseId phaseId) {
        return events;
    }

    /**
     * Get the message list.
     *
     * @return the message list.
     */
    @Override
    public List<PhaseMessage> getMessageList() {
        List result = new ArrayList<>();
        messagesMap.entrySet().stream().map((messageList) -> messageList.getValue()).forEach((value) -> {
            result.addAll(value);
        });
        return result;
    }

    /**
     * Get the message list.
     *
     * @param id the id.
     * @return the list of message, or null.
     */
    @Override
    public List<PhaseMessage> getMessageList(String id) {
        List result = messagesMap.get(id);
        if (result == null) {
            result = Collections.emptyList();
        }
        return Collections.unmodifiableList(result);
    }

    /**
     * Get the render kit.
     *
     * @return the render kit.
     */
    @Override
    public RenderKit getRenderKit() {
        return renderKit;
    }

    /**
     * Get the response complete flag.
     *
     * @return true if the response has been completed, false otherwise.
     */
    @Override
    public boolean getResponseComplete() {
        return false;
    }

    /**
     * Get the render response flag.
     *
     * @return true if we should render the response, false otherwise.
     */
    @Override
    public boolean getRenderResponse() {
        return renderResponse;
    }

    /**
     * Get the response writer.
     *
     * @return the response writer.
     */
    @Override
    public ResponseWriter getResponseWriter() {
        return responseWriter;
    }

    /**
     * Get the view root.
     *
     * @return the view root.
     */
    @Override
    public UIViewRoot getViewRoot() {
        return viewRoot;
    }

    /**
     * Is this a post back.
     *
     * @return true if it is, false otherwise.
     */
    @Override
    public boolean isPostback() {
        if (postback == null) {
            postback = request.getParameterMap().containsKey("org.omnifaces.serve.Postback");
        }
        return postback;
    }

    /**
     * Signal we are ready for render response.
     */
    @Override
    public void renderResponse() {
        renderResponse = true;
    }

    /**
     * Set the current phase id.
     *
     * @param phaseId the phase id.
     */
    @Override
    public void setCurrentPhaseId(PhaseId phaseId) {
        this.currentPhaseId = phaseId;
    }

    /**
     * Set the render kit.
     *
     * @param renderKit the render kit.
     */
    @Override
    public void setRenderKit(RenderKit renderKit) {
        this.renderKit = renderKit;
    }

    /**
     * Set the response writer.
     *
     * @param responseWriter the response writer.
     */
    @Override
    public void setResponseWriter(ResponseWriter responseWriter) {
        this.responseWriter = responseWriter;
    }

    /**
     * Set the view root.
     *
     * @param viewRoot the view root.
     */
    @Override
    public void setViewRoot(UIViewRoot viewRoot) {
        this.viewRoot = viewRoot;
    }
}
