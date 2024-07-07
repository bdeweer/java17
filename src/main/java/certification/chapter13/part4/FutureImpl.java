package certification.chapter13.part4;

import java.util.concurrent.*;

public class FutureImpl {

    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException{

        ExecutorService service = Executors.newSingleThreadExecutor();

        try {
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 2_000_000_000; i++) {
                    counter ++;
                }
            });
            result.get(75, TimeUnit.MILLISECONDS);
            System.out.println("Reached!");
            System.out.println(counter);

        }
        catch(TimeoutException e){
            System.out.println("Not reached in time;");
        }
        finally {
            service.shutdown();
        }
    }
}