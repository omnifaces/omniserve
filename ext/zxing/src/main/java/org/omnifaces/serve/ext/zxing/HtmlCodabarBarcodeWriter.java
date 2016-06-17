/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.CodaBarWriter;
import java.io.IOException;
import java.io.OutputStream;

/**
 * The "ZXing" writer for zxing:codabarBarcode.
 */
public class HtmlCodabarBarcodeWriter implements ZXingWriter {

    /**
     * Write the barcode.
     *
     * @param value the value.
     * @param height the height.
     * @param width the width.
     * @param outputStream the output stream.
     * @throws IOException when an I/O error occurs.
     */
    @Override
    public void writeBarcode(String value, Integer height, Integer width,
            OutputStream outputStream) throws IOException {
        try {
            CodaBarWriter writer = new CodaBarWriter();
            BitMatrix bitMatrix = writer.encode(value, BarcodeFormat.CODABAR, width, height);
            MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);
        } catch (WriterException we) {
            throw new IOException(we);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ioe) { // NOPMD
                }
            }
        }
    }
}
