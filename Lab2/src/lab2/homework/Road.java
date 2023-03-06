package lab2.homework;

public class Road {

    /**
     * instantiaza un drum nou
     * @param length
     * @param speedLimit
     * @param L1
     * @param L2
     */
        public Road(int length, int speedLimit, Location L1, Location L2) {

            this.L1=L1;
            this.L2=L2;
            Length = length;
            SpeedLimit = speedLimit;
        }

        private int Length, SpeedLimit;
        private Location L1, L2;


    /**
     * verifica daca un drum este legat de o anumita locatie  (daca un capat al drumului este egal cu locatia aleasa)
     * @param L
     * @return
     */
        Location CheckIfRoadIsLinkedToLocation(Location L)
        {
            if(L==(L1))
            {
                return L2;
            }
            else if(L==(L2))
            {
                return L1;
            }
            return null;
        }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Location getL1() {
        return L1;
    }

    public void setL1(Location l1) {
        L1 = l1;
    }

    public Location getL2() {
        return L2;
    }

    public void setL2(Location l2) {
        L2 = l2;
    }

    public int getLength() {
        return Length;
    }

    public void setLength(int length) {
        Length = length;
    }

    public int getSpeedLimit() {
        return SpeedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        SpeedLimit = speedLimit;
    }
}
 class Highway extends Road{
    public Highway(int length, int speedLimit, Location L1, Location L2)
    {
        super(length,speedLimit,L1,L2);
    }
 }

class Country extends Road{
    public Country(int length, int speedLimit, Location L1, Location L2)
    {
        super(length,speedLimit,L1,L2);
    }
}

class Express extends Road{
    public Express(int length, int speedLimit, Location L1, Location L2)
    {
        super(length,speedLimit,L1,L2);
    }
}