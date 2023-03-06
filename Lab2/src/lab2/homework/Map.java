package lab2.homework;

import java.util.ArrayList;
import java.util.List;

public class Map {

private List<Location> Locations =new ArrayList<>();
private List<Road> Roads= new ArrayList<>();

    /**
     * adauga o locatia noua in lista de locatii, doar daca nu exista deja
     * @param newLocation
     * @return
     */
public boolean AddLocation(Location newLocation)
{
    for (Location location: Locations
         ) {
        if(location == newLocation) return false;
    }
    Locations.add(newLocation);
    return true;
}

    /**
     * adauga un drum nou in lista de drumuri, doar daca nu exista deja
     * @param newRoad
     * @return
     */
public boolean AddRoad(Road newRoad)
    {
        for (Road road: Roads
        ) {
            if(road == newRoad) return false;
        }
        Roads.add(newRoad);
        return true;
    }

    /**
     * verifica daca o instanta este valida, adica daca distanta dintre doua locatii nu este mai mare decat lungimea drumului care le leaga
     * @return
     */
    boolean CheckIfInstanceIsValid()
    {
        for(int i=0;i < Roads.size();i++)
        {
            var Location1 = Roads.get(i).getL1();
            var Location2 = Roads.get(i).getL2();

            if(Roads.get(i).getLength() < Math.sqrt(Math.pow(Location1.getX()-Location1.getY(),2)+Math.pow(Location2.getX()-Location2.getY(),2)))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * verificam daca exista un drum intre doua locatii.
     * Parcurgem lista de drumuri si verificam in ce locatii putem ajunge parcurgand aceste drumuri
     * Locatiile in care ajungem le marcam ca "vizitate", prin intermediul unui parametru corespunzator fiecarei locatii
     * Ne oprim daca ajungem intr o locatie care este egala cu capatul drumului
     * Parametrul "visited" nu trebuie reinitializata cu "false" la fiecare pas, ci o singura data
     * @param LStart
     * @param LStop
     * @return
     */
    public boolean CheckIfExistsRoadBetweenLocations(Location LStart, Location LStop)
    {
        for(int i = 0 ; i < Locations.size(); i++)
            Locations.get(i).setVisited(false);
        return CheckIfExistsRoadBetweenLocationsInternal(LStart, LStop);
    }
    private boolean CheckIfExistsRoadBetweenLocationsInternal(Location LStart, Location LStop)
    {
        if(LStart == LStop) return true;
        for(int i=0;i< Roads.size();i++)
        {
            var otherPoint = Roads.get(i).CheckIfRoadIsLinkedToLocation(LStart);
            if(otherPoint != null && !otherPoint.isVisited())
            {
                otherPoint.setVisited(true);
                if(CheckIfExistsRoadBetweenLocationsInternal(otherPoint, LStop))
                    return true;
            }
        }
        return false;
    }
}
