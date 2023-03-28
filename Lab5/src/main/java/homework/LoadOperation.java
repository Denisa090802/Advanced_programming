package homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import compulsory.Catalog;

import java.io.File;
import java.io.IOException;

public class LoadOperation implements Operation{


    /**
     * @param catalog
     */
    @Override
    public void executeOperation(Catalog catalog) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Catalog catalogTemp =  objectMapper.readValue(new File("Catalog.json"),Catalog.class);
            for(int i = 0; i < catalogTemp.getDocuments().size(); i++)
            {
                catalog.addDoc(catalogTemp.getDocuments().get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
