package lab7.homework;

import lab7.compulsory.Map;
import lab7.compulsory.Robot;
import lab7.compulsory.SharedMemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Gavrila Denisa
 */
public class Main {
    private static final int n = 150;
    private static final int robotsNumber = 7;
    private static SharedMemory mem;
    private static List<Robot> robots = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, IOException {
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
                newRobot = new Robot("robot" + i, rand.nextInt(n), rand.nextInt(n),false, true);
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

        List<ActionThread> threads = new ArrayList<>();
        for (Robot robot : robots) {
            threads.add(new ActionThread(robot));
        }

        Timekeeper timekeeper = new Timekeeper(Duration.ofSeconds(100),threads);
        Thread timekeeperThread = new Thread(()->{
           timekeeper.run();
        });
        timekeeperThread.setDaemon(true);
        timekeeperThread.start();

        for (Thread thread : threads) {
            thread.start();
        }

        // comenzi tastatura

        while(true)
        {

            boolean finish = true;
            for(Robot robot : robots)
            {
                if(robot.running())
                {
                    finish = false;
                    break;
                }
            }
            if(finish) break;

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            String line = reader.readLine();
            if(line.equals("stop all"))
            {
                for(ActionThread thread : threads)
                {
                    thread.pauseAction();
                }
            }
            else
            {
                if(line.contains("stop ")) {
                    String robotNumber = line.replace("stop ", "");
                    int number = Integer.parseInt(robotNumber);
                    threads.get(number).pauseAction();
                }

            }

            if(line.equals("start all"))
            {
                for(ActionThread thread : threads)
                {
                    thread.run();
                }
            }
            else
            {
                if(line.contains("start ")) {
                    String robotNumber = line.replace("start ", "");
                    int number = Integer.parseInt(robotNumber);
                    threads.get(number).run();
                }

            }

        }

        for(Robot robot : robots)
        {
            System.out.println(robot.tokensCount());
        }
    }
}
