package compulsory;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public class Document {

    public DocumentType type;
    public int ID;
    public String nume;
    private Map<String,String> tags = new Hashtable<>();

    /**
     * constructor
     */
    public Document()
    {

    }


    /**
     * getter pentru id
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * @param _ID
     */
    public void setID(int _ID) { ID = _ID; }

    /**
     * getter pentru nume
     * @return
     */
    public String getNume() {
        return nume;
    }

    public void setNume(String _name) { nume = _name; }

    /**
     * transforma document in string
     * @return
     */
    @Override
    public String toString() {
        return "Nume: "+getNume()+", ID: "+getID()+", TAGS: "+ getTags();
    }

    /**
     * getter pentru tag-uri
     * @return
     */
    public Map<String, String> getTags() {
        return tags;
    }

    /**
     * @param tags
     */
    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }
}
