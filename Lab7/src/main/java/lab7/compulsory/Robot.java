package lab7.compulsory;

import org.javatuples.Pair;

import java.util.*;

/**
 * @author Gavrila Denisa
 */
public class Robot implements Runnable {
    private String name;
    private boolean isRunning;
    private int xPos;
    private int yPos;
    private List<Token> tokens = new ArrayList<>();

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' + ", x=" + xPos + ", y=" + yPos + ", tokens=" + tokens + '}';
    }

    public String tokensCount() {
        return "Robot{" +
                "name='" + name + '\'' + ", tokens=" + tokens.size() + '}';
    }

    public Robot(String name, int xPos, int yPos, boolean printString, boolean isRandom) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.printString = printString;
        this.isRandom = isRandom;

        isRunning = true;
    }

    public boolean getPrintSTring()
    {
        return printString;
    }

    private boolean printString;

    private Boolean isRandom;
    public String getName() { return name; }
    public int getxPos() { return xPos; }
    public int getyPos() { return yPos; }
    public void setxPos(int xPos) { this.xPos = xPos; }
    public void setyPos(int yPos) { this.yPos = yPos; }

    public boolean isOverlapping(Robot r)
    {
        return isOverlapping(new Pair<>(r.xPos, r.yPos));
    }

    public boolean isOverlapping(Pair<Integer, Integer> position)
    {
        return position.getValue0() == xPos &&
                position.getValue1() == yPos;
    }

    @Override
    public void run() {
        while(isRunning)
        {
            if(isRandom)
            {
                if(Map.exploreRandom(this) == false)
                {
                    System.out.println(name + " finished exploration");
                    isRunning = false;
                }
            } else {
                if(Map.exploreLogic(this) == false)
                {
                    System.out.println(name + " finished exploration");
                    isRunning = false;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void pause() {

        isRunning = false;
    }

    public void start() {

        isRunning = true;
        run();
    }

    public boolean running()
    {
        return isRunning;
    }

    int direction = 0;

    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    public int getDirection()
    {
        return direction;
    }

}
