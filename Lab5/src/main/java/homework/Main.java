package homework;

import compulsory.Catalog;
import compulsory.Document;
import compulsory.Operations;

public class Main {

    public static void main(String[] args) {

        Catalog catalog  = new Catalog();

        new LoadOperation().executeOperation(catalog);
        new ListOperation().executeOperation(catalog);
        new ViewOperation().executeOperation(catalog);
        new ReportOperation().executeOperation(catalog);
    }
}
