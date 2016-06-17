/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.chartjs;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.Renderer;
import org.omnifaces.serve.renderkit.ResponseWriter;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The renderer for chartjs:barChart.
 */
@ServeRenderer(componentFamily = "org.omnifaces.serve.ext.chartjs",
        rendererType = "org.omnifaces.serve.ext.chartjs.HtmlBarChart")
public class HtmlBarChartRenderer implements Renderer<PhaseContext, UIComponent> {

    /**
     * Encode.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        ResponseWriter writer = context.getResponseWriter();
        String id = (String) component.getValueExpression("id").getValue(context.getELContext());
        writer.startElement("script");
        writer.writeAttribute("src", "?org.omnifaces.serve.ext.chartjs.ChartJs=true");
        writer.endElement("script");
        writer.startElement("canvas");
        writer.writeAttribute("id", id);
        String width = (String) component.getValueExpression("width").getValue(context.getELContext());
        writer.writeAttribute("width", width);
        String height = (String) component.getValueExpression("height").getValue(context.getELContext());
        writer.writeAttribute("height", height);
        writer.endElement("canvas");
        writer.startElement("script");
        writer.writeText("var " + id + "_ctx = document.getElementById(\"" + id + "\");");
        String data;
        try {
            StringWriter stringWriter = new StringWriter();
            JAXBContext jaxbContext = JAXBContext.newInstance(BarChartData.class, BarChartDataSet.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(component.getValueExpression("value").getValue(context.getELContext()), stringWriter);
            data = stringWriter.toString();
        } catch (JAXBException jex) {
            data = "";
        }

        writer.writeText("var " + id + "_data = " + data + ";");
        writer.writeText("var " + id + "_chart = new Chart(" + id + "_ctx, {"
                + "    type: 'bar',"
                + "    data: " + id + "_data"
                + "});");
        writer.endElement("script");
    }
}
