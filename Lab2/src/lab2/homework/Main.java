package lab2.homework;

public class Main {



    public static void main(String[] args)
    {
        GasStation L1=new GasStation("Bacau",123,263,45);
        AirPort L2=new AirPort("Otopeni", 567, 678, 3);
        AirPort L3=new AirPort("Henri Coanda", 456, 986, 2);
        City L4=new City("Buzau",78,89, 200000);
        Highway R1=new Highway(400, 150, L1, L2);
        Express R2=new Express(300,90, L2, L4 );
        Map map = new Map();
        map.AddLocation(L1);
        map.AddLocation(L2);
        map.AddLocation(L3);
        map.AddLocation(L4);
        map.AddRoad(R1);
        map.AddRoad(R2);
        if(map.CheckIfExistsRoadBetweenLocations(L1,L4)==true)
        {
            System.out.println("there is a road between " + L1.getLocationName() + " and " + L2.getLocationName());
        }

        System.out.println(L1);
    }


}
