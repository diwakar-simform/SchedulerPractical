import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Scheduler - Practical
- Create class that implement Runnable interface.

- Create main class and create object ScheduledExecutorService with 10 thread pool size.

- Create 5 worker thread and schedule for execution in thread pool.

- Print message on console for each thread execution.
 */
class Job extends Thread {

    public void run() {
        // this method code is executed by Thread
        System.out.println("Job started by Thread : " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            System.out.println("I got interrupted");
        }

        System.out.println("Job Completed by Thread : " + Thread.currentThread().getName());
    }
}
public class Main {

    public static void main(String[] args) {
        Job[] jobs = {
                new Job(),
                new Job(),
                new Job(),
                new Job(),
                new Job()
        };

        ExecutorService service = Executors.newFixedThreadPool(10); // creates a thread pool

        // submitting job to the thread pool
        for (Job job : jobs) {
            service.submit(job);
        }

        service.shutdown(); // stops thread pool execution

    }
}
