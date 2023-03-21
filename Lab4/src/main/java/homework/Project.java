package homework;

public class Project implements Comparable<homework.Project>{

    String name;

    /**
     * constructor
     * @param _name
     */
    public Project(String _name)
    {
        name = _name;
    }

    public Project() { }

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
    public int compareTo(homework.Project o) {
        return GetName().compareTo(o.GetName());
    }
}

