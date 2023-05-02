package lab7.homework;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Timekeeper implements Runnable {

    public Timekeeper(Duration maxDuration, List<ActionThread> threads)
    {
        this.maxDuration = maxDuration;
        start = Instant.now();
        running = true;
        this.threads = threads;

    }
    private Instant start;
    private Duration maxDuration;

    private boolean running;

    private List<ActionThread> threads;
    @Override
    public void run() {

        while (running)
        {
            System.out.println("Second:" + Duration.between(start, Instant.now()).getSeconds());
            if(Duration.between(start, Instant.now()).getSeconds() > maxDuration.getSeconds()) {
                System.out.println("S a terminat timpul");
                for(Thread thread: threads)
                {
                    thread.stop();
                }
                break;
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
