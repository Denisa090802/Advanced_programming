package lab3.compulsory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Node> nodeList = new ArrayList<>();
        nodeList.add(new Person("Denisa"));
        nodeList.add(new Person("Maria"));
        nodeList.add(new Company("FII"));

        nodeList.forEach((node -> {
            System.out.println(node.GetName());
        }));
    }
}