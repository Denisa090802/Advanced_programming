package lab7.compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Gavrila Denisa
 */
public class Main {
    private static final int n = 7;
    private static final int robotsNumber = 7;
    private static SharedMemory mem;
    private static List<Robot> robots = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        SharedMemory.setupSharedMemory(n);
        Map.setupMap(n);
        for(int i = 0; i < robotsNumber; i++)
        {
            Random rand = new Random();
            Robot newRobot = null;
            boolean Ok = false;
            while(!Ok)
            {
                Ok = true;
                newRobot = new Robot("robot" + i, rand.nextInt(n), rand.nextInt(n),true, true);
                for(int q = 0; q < robots.size() && Ok; q++)
                {
                    if(robots.get(q).isOverlapping(newRobot))
                    {
                        Ok = false;
                    }
                }
            }
            robots.add(newRobot);
        }
        System.out.println("Initialized");

        List<Thread> threads = new ArrayList<>();
        for (Robot robot : robots) {
            var thread = new Thread(() -> {
                System.out.println(robot);
                robot.run();
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for(Robot robot : robots)
        {
            System.out.println(robot);
        }
    }
}