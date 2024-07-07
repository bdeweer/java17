package certification.chapter13.part4;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableImpl {

    public static void main(String[] args) throws Exception{

        var service = Executors.newSingleThreadExecutor();

        try {

            Future<?> resultRunnable = service.submit(() -> {

                try{
                    Thread.sleep(50000);
                }catch(InterruptedException e){}
                System.out.println("Runnable");
            });

            Future<String> resultCallable = service.submit(() -> "Monkey");
            Future<Integer> resultCallable2 = service.submit(() -> 30+40);



            //System.out.println(resultCallable.get());
            //System.out.println(resultCallable2.get());

        } finally {
            service.shutdown();
        }

        service.awaitTermination(15, TimeUnit.SECONDS); //Au bout de 15s, check if all tasks have finished
        System.out.println("ici");

        if(service.isTerminated()){
            System.out.println("Finished");
        }
        else {
            System.out.println("At least one task is still running");
        }
    }
}