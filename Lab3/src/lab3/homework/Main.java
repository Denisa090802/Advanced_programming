package lab3.homework;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        Company company1 = new Company("Compania X");
        Company company2 = new Company("Compania Y");
        Person person1 = new Person("Denisa");
        Person person2 = new Person("Stefan");
        Person person3 = new Person("Maria");
        Person person4 = new Person("Alexandra");
        network.AddNode(company1);
        network.AddNode(company2);
        network.AddConection(person1, company2, "Angajat");
        network.AddConection(person1, person2, "prieteni");
        network.AddConection(person1, person3, "prieteni");
        network.AddConection(person1, person4, "prieteni");

        System.out.println(network.PrintNetwork());
    }
}
