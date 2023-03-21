package compulsory;

import java.util.ArrayList;
import java.util.List;

public class Catalog {


    private List<Document> documents = new ArrayList<>();

    /**
     * getter pentru documente
     * @return
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * adauga documente
     * @param document
     */
    public  void addDoc(Document document)
    {
        documents.add(document);
    }


}
