package lab2.compulsory;

import java.util.Objects;

public class Road {
    public Road(RoadType type, int length, int speedLimit) {
        Type = type;
        Length = length;
        SpeedLimit = speedLimit;
    }

    private RoadType Type;
    private int Length, SpeedLimit;

    public RoadType getType() {
        return Type;
    }

    public void setType(RoadType type) {
        Type = type;
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

    @Override
    public String toString() {
        return "Road{" +
                "Type=" + Type +
                ", Length=" + Length +
                ", SpeedLimit=" + SpeedLimit +
                '}';
    }
}

