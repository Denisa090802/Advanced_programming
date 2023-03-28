package homework;

import compulsory.Catalog;

public class ListOperation implements Operation{

    /**
     * @param catalog
     */
    @Override
    public void executeOperation(Catalog catalog) {
        for(int i=0;i<catalog.getDocuments().size();i++)
        {
            System.out.println(catalog.getDocuments().get(i));
        }
    }
}
