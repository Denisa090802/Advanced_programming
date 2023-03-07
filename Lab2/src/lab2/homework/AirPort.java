package lab2.homework;

class AirPort extends Location
{
    int numberOfTerminals;
    public AirPort(String airPortName,int x,int y, int numberOfTerminals )
    {
        super(airPortName,x,y);
        this.numberOfTerminals=numberOfTerminals;
    }
}
