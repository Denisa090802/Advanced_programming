package lab3.homework;

public class Company implements Node{

    String companyName;
    int numberOfEmployees=0;

    public Company(String _companyName)
    {
        companyName = _companyName;
    }

    /**
     * Creste numarul de angajati
     */
    public void IncreaseNumberOfEmployees()
    {
        numberOfEmployees++;
    }

    /**
     * returneaza numarul de conexinui
     * conexiunile facute de companii sunt numai cu angajati
     * deci numarul de conexiuni va fi egal cu numarul de angajati
     * @return
     */
    @Override
    public int NumberOfConnections() {
        return numberOfEmployees;
    }

    @Override
    public String GetType() {
        return "Company";
    }

    @Override
    public String GetName() {
        return companyName;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(o.NumberOfConnections() , NumberOfConnections());
    }
}
