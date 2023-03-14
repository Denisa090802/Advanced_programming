package lab3.homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Person implements Node{

    Map<Node, String> map = new HashMap<>();
    String name;

    /**
     * constructor
     * @param _name
     */
    public Person(String _name)
    {
        name = _name;
    }

    /**
     * adauga in map o relatie
     * @param node
     * @param relationship
     */
    public void AddRelation(Node node, String relationship)
    {
        map.put(node, relationship);
    }

    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Node o) {
        return Integer.compare(o.NumberOfConnections() , NumberOfConnections());
    }

    /**
     * returneaza numarul de conexiuni, care este egal cu numarul de elemente din map
     * @return
     */
    @Override
    public int NumberOfConnections() {
        return map.size();
    }

    @Override
    public String GetType() {
        return "Person";
    }

    @Override
    public String GetName() {
        return name;
    }
}
