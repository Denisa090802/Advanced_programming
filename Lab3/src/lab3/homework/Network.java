package lab3.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Network implements Comparable {
    List<Node> nodes = new ArrayList();

    /**
     * adauga un nod in retea
     * @param node
     */
    public void AddNode(Node node) {

        for(int i=0;i< nodes.size();i++)
            if(nodes.get(i) == node)
                return;
        nodes.add(node);
    }

    /**
     * Adauga o conexiune intre doua noduri
     * odata cu adaugarea unei conexiuni, se adauga cele doua noduri in lista de noduri
     * @param node1
     * @param node2
     * @param connection
     */
    public void AddConection(Node node1, Node node2, String connection)
    {
        AddNode(node1);
        AddNode(node2);
        if(node1.GetType() == "Person")
        {
            ((Person)node1).AddRelation(node2, connection);
        }

        if(node2.GetType() == "Person")
        {
            ((Person)node2).AddRelation(node1, connection);
        }
        if(node1.GetType() == "Company")
        {
            ((Company)node1).IncreaseNumberOfEmployees();
        }
        if(node2.GetType() == "Company")
        {
            ((Company)node2).IncreaseNumberOfEmployees();
        }
    }

    /**
     * construieste si afiseaza reteaua de relatii
     * @return
     */
    public String PrintNetwork()
    {
        Collections.sort(nodes);
        StringBuilder builder = new StringBuilder();
        for(int i=0;i< nodes.size();i++)
        {
            builder.append(nodes.get(i).GetName() + "\n");
        }

        return builder.toString();
    }

    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Object o) {
        return 0;

    }
}
