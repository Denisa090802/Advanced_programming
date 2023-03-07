package lab2.homework;

class GasStation extends Location
{
    int gasPrice;
    public GasStation(String gasStationName,int x,int y,int gasPrice)
    {
        super(gasStationName,x,y);
        this.gasPrice = gasPrice;
    }
}

