package certification.chapter13.part6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {

    private final AtomicInteger sheepCount = new AtomicInteger(0);
   // private int sheepCount;

    private synchronized void incrementAndReport(){
        synchronized (this){
            System.out.println(sheepCount.incrementAndGet() + " ");
           // System.out.println(++sheepCount);
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);

        try {
            SheepManager manager = new SheepManager();

            for (int i = 0; i < 10; i++) {
                synchronized (manager){
                    service.submit(manager::incrementAndReport);
                }
            }

        }finally {
            service.shutdown();
        }
    }
}