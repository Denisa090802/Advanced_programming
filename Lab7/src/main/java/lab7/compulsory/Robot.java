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

    public Robot(String name, int xPos, int yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;

        isRunning = true;
    }

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
            if(Map.exploreRandom(this) == false)
            {
                System.out.println(name + " finished exploration");
                isRunning = false;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
}
