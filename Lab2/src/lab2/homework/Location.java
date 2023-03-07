package lab2.homework;


public class Location {

    private String locationName;
    private  boolean visited;
    private int x,y;

    /**
     * instantiaza o locatie noua
     * @param locationName
     * @param x
     * @param y
     */
    public Location(String locationName, int x, int y) {
        this.locationName = locationName;
        this.x = x;
        this.y = y;
        this.visited = false;


    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}




