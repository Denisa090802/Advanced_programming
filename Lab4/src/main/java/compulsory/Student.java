package compulsory;

public class Student implements Comparable<Student>{

    String name;

    /**
     * constructor
     * @param _name
     */
    public Student(String _name)
    {
        name = _name;
    }

    /**
     * returneaza numele studentului
     * @return
     */
    public String GetName()
    {
        return name;
    }

    /**
     * compara un student cu un altul
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Student o) {
        return GetName().compareTo(o.GetName());
    }
}
