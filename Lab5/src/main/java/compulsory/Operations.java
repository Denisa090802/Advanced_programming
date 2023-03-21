package compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Operations {

    /**
     * adauga document in catalog
     * @param catalog
     * @param document
     */
    public void add(Catalog catalog, Document document)
    {
        catalog.addDoc(document);
    }

    /**
     * transforma un catalog in string
     * @param catalog
     * @return
     */
    public String toString(Catalog catalog)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<catalog.getDocuments().size();i++)
        {
            sb.append(catalog.getDocuments().get(i));
            sb.append(",\n");
        }
        return sb.toString();
    }

    /**
     * salveaza catalogul ca json
     * @param catalog
     */
    public void save(Catalog catalog)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("Catalog.json"),catalog);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * initializeaza catalog cu informatia din json
     * @return
     */
    public Catalog load()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("Catalog.json"),Catalog.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
