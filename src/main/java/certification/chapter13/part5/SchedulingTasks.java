package certification.chapter13.part5;

import java.util.concurrent.*;

public class SchedulingTasks {

    public static void main(String[] args) throws Exception{

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Runnable task1 = () -> System.out.println("Hello zoo");
        Callable<String> task2 = () -> "Monkey";

        ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        ScheduledFuture<String> r2 = service.schedule(task2, 15, TimeUnit.SECONDS);

        System.out.println("Shuting down");
        service.shutdown();

        service.awaitTermination(5, TimeUnit.SECONDS);

        if(service.isTerminated()){
            System.out.println("Finished");
        }
        else {
            System.out.println("At least one task is still running");

        }
    }
}
