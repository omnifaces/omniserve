/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor;

import java.util.Iterator;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import org.omnifaces.serve.component.EditableValueHolder;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.ValueHolder;
import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.converter.Converter;
import org.omnifaces.serve.event.ActionSource;
import org.omnifaces.serve.event.MethodExpressionActionListener;
import org.omnifaces.serve.validator.MethodExpressionValidator;
import org.omnifaces.template.Processor;
import org.omnifaces.template.TagAttribute;
import org.omnifaces.template.TagProcessor;

/**
 * The Serve tag processor.
 */
public class ServeTagProcessor extends TagProcessor<ServeProcessorContext, UIComponent> {

    /**
     * Create the component.
     *
     * @param <T> the component class.
     * @param componentType the component type.
     * @param clazz the class.
     * @param context the context.
     * @param parent the parent component.
     * @param index the index.
     * @return the component.
     */
    protected <T extends UIComponent> T createComponent(Class clazz,
            String componentType, ServeProcessorContext context, UIComponent parent, int index) {
        T component = (T) context.createComponent(componentType);
        parent.getChildren().add(component);
        return component;
    }

    /**
     * Get the closest parent of the given type.
     *
     * @param <T> the component type.
     * @param component the UI component.
     * @param type the expected class type.
     * @return the closest parent.
     */
    protected <T extends Object> T getClosestParent(UIComponent component, Class<T> type) {
        T result;
        if (component == null) {
            result = null;
        } else if (type.isInstance(component)) {
            result = type.cast(component);
        } else {
            result = getClosestParent(component.getParent(), type);
        }
        return result;
    }

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        Iterator<Processor<ServeProcessorContext, UIComponent>> iterator = children.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Processor<ServeProcessorContext, UIComponent> processor = iterator.next();
            processor.process(context, parent, i);
            if (!context.isProcessing()) {
                break;
            }
            /*
             * If we are not processing an attached object processor we are
             * expecting it to add a UIComponent to the tree, otherwise we
             * expect it to add nothing.
             */
            if (!(processor instanceof ServeAttachedObjectProcessor)) {
                i++;
            }
        }
    }

    /**
     * Process action source attributes.
     *
     * @param context the context.
     * @param actionSource the action source.
     */
    protected void processActionSourceAttributes(ServeProcessorContext context, ActionSource actionSource) {
        if (attributes.containsKey("action")) {
            MethodExpression me = context.getExpressionFactory().createMethodExpression(
                    context.getContext().getELContext(),
                    attributes.get("action").getValue(),
                    Object.class,
                    new Class<?>[]{});
            actionSource.setActionExpression(me);
        }
        if (attributes.containsKey("actionListener")) {
            MethodExpression me = context.getExpressionFactory().createMethodExpression(
                    context.getContext().getELContext(),
                    attributes.get("actionListener").getValue(),
                    Void.class,
                    new Class<?>[]{});
            actionSource.addActionListener(new MethodExpressionActionListener(me));
        }
    }

    /**
     * Process the editable value holder attributes.
     *
     * @param context the context.
     * @param component the UI component.
     */
    protected void processEditableValueHolderAttributes(ServeProcessorContext context, EditableValueHolder component) {
        processValueExpressionAttribute(context, (UIComponent) component, "required", boolean.class);
        if (attributes.containsKey("validator")) {
            String attributeString = attributes.get("validator").getValue();
            MethodExpression me = context.getExpressionFactory().createMethodExpression(
                    context.getContext().getELContext(), attributeString, Void.class, new Class[]{
                        Context.class, UIComponent.class, Object.class
                    });
            MethodExpressionValidator validator = new MethodExpressionValidator();
            validator.setMethodExpression(me);
            component.addValidator(validator);
        }
    }

    /**
     * Process event attributes.
     *
     * @param context the context.
     * @param component the UI component.
     */
    protected void processEventAttributes(ServeProcessorContext context, UIComponent component) {
        processValueExpressionAttribute(context, component, "onclick", String.class);
        processValueExpressionAttribute(context, component, "ondblclick", String.class);
        processValueExpressionAttribute(context, component, "onkeydown", String.class);
        processValueExpressionAttribute(context, component, "onkeypress", String.class);
        processValueExpressionAttribute(context, component, "onkeyup", String.class);
        processValueExpressionAttribute(context, component, "onmousedown", String.class);
        processValueExpressionAttribute(context, component, "onmousemove", String.class);
        processValueExpressionAttribute(context, component, "onmouseout", String.class);
        processValueExpressionAttribute(context, component, "onmouseover", String.class);
        processValueExpressionAttribute(context, component, "onmouseup", String.class);
    }

    /**
     * Process any and all pass through attributes.
     *
     * @param context the context.
     * @param component the UI component.
     */
    protected void processPassthroughAttributes(ServeProcessorContext context, UIComponent component) {
        Iterator<TagAttribute> iterator = attributes.values().iterator();
        while (iterator.hasNext()) {
            TagAttribute attribute = iterator.next();
            if (attribute.getUri().equals("http://www.omnifaces.org/serve/passthrough")) {
                component.getPassThroughAttributes().put(attribute.getLocalName(), attribute.getValue());
            }
        }
    }

    /**
     * Process a value expression attribute.
     *
     * @param context the context.
     * @param component the UI component.
     * @param attributeName the attribute name.
     * @param returnType the return type.
     */
    protected void processValueExpressionAttribute(
            ServeProcessorContext context, UIComponent component,
            String attributeName, Class returnType) {
        if (attributes.containsKey(attributeName)) {
            String attributeString = attributes.get(attributeName).getValue();
            ValueExpression ve = context.getExpressionFactory().createValueExpression(
                    context.getContext().getELContext(), attributeString, returnType);
            component.setValueExpression(attributeName, ve);
        }
    }

    /**
     * Process the value holder attributes.
     *
     * @param context the context.
     * @param valueHolder the value holder.
     */
    protected void processValueHolderAttributes(ServeProcessorContext context, ValueHolder valueHolder) {
        processValueExpressionAttribute(context, (UIComponent) valueHolder, "converter", Converter.class);
        processValueExpressionAttribute(context, (UIComponent) valueHolder, "value", Object.class);
    }
}
