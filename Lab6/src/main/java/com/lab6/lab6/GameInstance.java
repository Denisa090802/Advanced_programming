package com.lab6.lab6;

import javafx.scene.shape.Line;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Hashtable;

public class GameInstance {

    public GameInstance(int numberOfPoints, Boolean isFirstPlayer, ArrayList<Pair<Point, Point>> linePoints, ArrayList<Pair<Point, Point>> redLines, ArrayList<Pair<Point, Point>> blueLines) {
        this.numberOfPoints = numberOfPoints;
        this.isFirstPlayer = isFirstPlayer;
        this.linePoints = linePoints;
        this.redLines = redLines;
        this.blueLines = blueLines;
    }

    public int numberOfPoints;
    public Boolean isFirstPlayer;
    public ArrayList<Pair<Point, Point>> linePoints;
    public ArrayList<Pair<Point, Point>> redLines;
    public ArrayList<Pair<Point, Point>> blueLines;
}
