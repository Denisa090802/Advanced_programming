package lab3.compulsory;

import java.util.Comparator;

public class Company implements Node, Comparable<Company> {

    private String name;

    /**
     * constructor
     * @param name
     */
    public Company(String name)
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
     * Compara compania curenta cu cea data ca parametru
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Company o) {
       return this.name.compareTo(o.name);    }
}
