package lab2.compulsory;

import java.util.Objects;

public class Location {
    public Location(String name, int x, int y, LocationType type) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    private String name;
    private int x,y;

    private LocationType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", type=" + type +
                '}';
    }
}

