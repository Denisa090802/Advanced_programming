package lab7.homework;

import lab7.compulsory.Robot;

public class ActionThread extends Thread {

    public ActionThread(Robot robot)
    {
        this.robot = robot;
    }

    Robot robot;

    public void run()
    {
        robot.start();
    }

    public void pauseAction()
    {
        robot.pause();
    }
}
