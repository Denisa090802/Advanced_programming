package lab2.homework;

class City extends Location {

    int population;
    public City(String cityName, int x, int y,int population)
    {
        super(cityName,x,y);
        this.population=population;
    }

}
