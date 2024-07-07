package certification.chapter13.part4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyAPI {

    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();

        Runnable printInventory = () -> System.out.println("Printing zoo inventory");

        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };

        try {
            System.out.println("Begin");
            service.execute(printInventory);
            service.execute(printRecords);
            service.execute(printInventory);
            System.out.println("end");

            Future<?> future = service.submit(() -> System.out.println("Hello"));

        } finally {
            service.shutdown();
            System.out.println(service.isShutdown());
            System.out.println(service.isTerminated());
        }

      //  service.awaitTermination(1, TimeUnit.MINUTES);

       // if(service.isTerminated()){
      //      System.out.println("Finished");
     //   }else {
     //       System.out.println("At least one task is still running");
     //  }
    }
}
