package homework;

import compulsory.Catalog;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewOperation implements Operation{

    /**
     * @param catalog
     */
    @Override
    public void executeOperation(Catalog catalog) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop desktop = Desktop.getDesktop();
                File myFile = new File("Catalog.json");
                desktop.open(myFile);
            } catch (IOException ex) {}
        }

    }
}
