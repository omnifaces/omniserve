/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import org.omnifaces.template.Processor;
import org.omnifaces.template.XmlDefaultHandler2;

/**
 * The DefaultHandler2.
 */
@Dependent
@Default
public class ServeDefaultHandler2 extends XmlDefaultHandler2<Object, Object> {

    /**
     * Peek the stack.
     *
     * @return the object at the top of the stack.
     */
    public Processor peek() {
        return stack.peek();
    }

    /**
     * Pop the stack.
     */
    public void pop() {
        stack.pop();
    }

    /**
     * Push onto the stack.
     *
     * @param processor the processor.
     */
    public void push(Processor processor) {
        stack.push(processor);
    }
}
