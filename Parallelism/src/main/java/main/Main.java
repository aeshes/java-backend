package main;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        Service service = new Service();

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                service.service();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
    }
}
