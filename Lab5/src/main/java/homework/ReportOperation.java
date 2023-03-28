package homework;

import compulsory.Catalog;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.awt.*;
import java.io.*;

public class ReportOperation implements Operation{

    /**
     * @param catalog
     */
    @Override
    public void executeOperation(Catalog catalog) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        Template t = velocityEngine.getTemplate("index.vm");

        VelocityContext context = new VelocityContext();
        context.put("documents", catalog.getDocuments());

        StringWriter writer = new StringWriter();
        t.merge( context, writer );

        try{
            Writer fileWriter = new FileWriter("report.html", false);
            fileWriter.write(writer.toString());
            fileWriter.flush();

            Desktop desktop = Desktop.getDesktop();
            File myFile = new File("report.html");
            desktop.open(myFile);
        }
        catch (IOException ex) {
            throw new CustomException("something went wrong...");
        }
    }
}
