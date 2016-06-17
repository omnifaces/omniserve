/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.zxing;

import java.io.IOException;
import java.io.OutputStream;

/**
 * The interface each "zxing" Writer needs to implement.
 */
public interface ZXingWriter {

    /**
     * Write the bar-code.
     *
     * @param value the value.
     * @param height the height.
     * @param width the width.
     * @param outputStream the output stream.
     * @throws IOException when an I/O error occurs.
     */
    void writeBarcode(String value, Integer height, Integer width, OutputStream outputStream) throws IOException;
}
