package certification.chapter13.part1;

import java.util.concurrent.*;

public class Concurrency {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Start main : " + Thread.currentThread().getName());

        new Thread(() -> System.out.println("Hello")).start();
        Thread.sleep(1);
        System.out.println("World");

        Thread t = new Thread("New Thread"){
            public void run(){
                System.out.println("Anonymous run : " + getName());
            }
        };
        t.start();

        Thread primeThread = new PrimeThread(5L, "Thread subclass");
        primeThread.start();

        Runnable r = new PrimeRun(5L);
        t = new Thread(r, "Runnable impl");
        t.start();

        Runnable lambdaRun = () -> System.out.println("Lambda runnable running - " + Thread.currentThread().getName());
        t = new Thread(lambdaRun, "Runnable lambda");
        t.start();

        System.out.println("Continue ...");
    }
}