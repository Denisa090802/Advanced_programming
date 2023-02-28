package lab2.compulsory;

public class Main {
    public static void main(String[] args) {

        Location L1 = new Location("Iasi", 123, 456, LocationType.City);
        Location L2 = new Location("Bacau", 321, 654, LocationType.City);
        Road R = new Road(RoadType.Highway, 150, 100);

        System.out.println(L1);
        System.out.println(L2);
        System.out.println(R);
    }
}