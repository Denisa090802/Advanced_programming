package compulsory;

public class Main {
    public static void main(String[] args) {
        Document doc = new Document();
        Catalog catalog = new Catalog();
        Operations op = new Operations();
        doc.nume="Carte";
        doc.ID=1;
        doc.getTags().put("autor", "Denisa");
        doc.getTags().put("title", "Primavara");
        doc.getTags().put("year", "2020");

        Document doc1 = new Document();
        doc1.nume="Roman";
        doc1.ID=2;

        op.add(catalog,doc);
        op.add(catalog,doc1);
        System.out.println(op.toString(catalog));

        op.save(catalog);

        Catalog catalog1 = op.load();
        System.out.println(op.toString(catalog1));

    }
}
