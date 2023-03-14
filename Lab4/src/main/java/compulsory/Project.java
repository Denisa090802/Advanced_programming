package compulsory;

public class Project implements Comparable<Project>{

    String name;

    /**
     * constructor
     * @param _name
     */
    public Project(String _name)
    {
        name = _name;
    }

    /**
     * returneaza numele proiectului
     * @return
     */
    public String GetName()
    {
        return name;
    }

    /**
     * compara un proiect cu un altul
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Project o) {
        return GetName().compareTo(o.GetName());
    }
}
