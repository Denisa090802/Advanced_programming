package lab3.compulsory;

import java.util.Comparator;

public class Person implements Node, Comparable<Person> {

    private String name;

    /**
     * constructor
     * @param name
     */
    public Person(String name)
    {
        this.name=name;
    }


    /**
     * returneaza numele
     * @return
     */
    @Override
    public String GetName() {
        return name;
    }

    /**
     * compara persoana curenta cu persoana primita ca parametru
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
