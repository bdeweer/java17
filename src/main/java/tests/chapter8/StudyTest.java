package tests.chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.*;

public class StudyTest {

    public static void main(String ... args) throws InterruptedException, ExecutionException {

        ExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        final long [] value2 = {2};

        //12
        ExecutorService service = Executors.newFixedThreadPool(4);
        try {
            service.execute(() -> takeNap());
            service.execute(() -> takeNap());
            service.execute(() -> takeNap());
        }finally {
            service.shutdown();
        }
        service.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("DONE");

        //13
        System.out.println(
                List.of("duck", "flamingo", "pelican")
                        .parallelStream()
                .parallel().reduce(
                        0,
                        (c1, c2) -> c1 + c2.length(),
                        (s1, s2) -> s1+s2
                )
        );

        //14
        Object o1 = new Object();
        Object o2 = new Object();
        var service14 = Executors.newFixedThreadPool(2);
        var f1 = service14.submit(() -> {
            synchronized (o1){
                synchronized (o2){
                    System.out.println("Turtoise");
                }
            }
        });
        var f2 = service14.submit(() -> {

            synchronized (o2){
                synchronized (o1){
                    System.out.println("Hare");
                }
            }
        });
        f1.get();
        f2.get();

        //15
        var cats = Stream.of("leopard", "lynx", "ocelot", "puma")
                .parallel();
        var bears = Stream.of("panda", "grizzly", "polar")
                .parallel();
        var data =
                Stream
                        .of(cats, bears).flatMap(a -> a)
                        .collect(Collectors.groupingByConcurrent(s -> !s.startsWith("p")));
        System.out.println(data.get(false).size() + " " + data.get(true).size(
        ));

        //21
        var data21 = List.of(List.of(1,2), List.of(3,4), List.of(5,6));
        data21.stream().flatMap(s -> s.stream()).findFirst().ifPresent(System.out::println);

    }

    private static void takeNap(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Bank {
    private Lock vault = new ReentrantLock();
    private int total = 0;
    public void deposit(int value){
        try {
            vault.tryLock();
            total += value;
        }finally {
            vault.unlock();
        }
    }

    public static void main(String[] args) {
        var bank = new Bank();
        IntStream.range(1,10).parallel().forEach(s -> bank.deposit(s));
        System.out.println(bank.total);
    }
}

class Flavors {
    private static int counter;
    public static void countIceCreamFlavors(){
        counter = 0;
        Runnable task = () -> counter++;
        LongStream.range(0, 500).forEach(m -> new Thread(task).run());
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countIceCreamFlavors();
    }
}

//16
class RocketShip {
    private volatile int fuel;

    private void launch(int checks){
        var p = new ArrayList<Thread>();
        for (int i = 0; i < checks; i++) {
            p.add(new Thread(() -> fuel++));
        }
        p.forEach(Thread::interrupt);
        p.forEach(Thread::run);
        p.forEach(Thread::interrupt);
    }
    public static void main(String[] args) throws Exception{
        var ship = new RocketShip();
        ship.launch(100);
        Thread.sleep(60*1000);
        System.out.println(ship.fuel);
    }
}

//19
class PrintConstants {
    public static void main(String[] args) {

        var s = Executors.newScheduledThreadPool(2);
        DoubleStream
                .of(3.14159, 2.71828)
                .forEach(
                        c ->
                                s.submit(
                                        () -> System.out.println(10*c))
                )
        ;
        s.execute(() -> System.out.println("printed"));
    }
}

//22
class BedTime {
    private AtomicInteger s1 = new AtomicInteger(0);
    private int s2 = 0;

    private void countSheep() throws InterruptedException {
        var service = Executors.newSingleThreadExecutor();
        try {
            for (int i = 0; i < 100; i++) {
                service.execute(() -> {
                    s1.getAndIncrement();
                    s2++;
                });
             }
            Thread.sleep(60*1000);
            System.out.println(s1 + " " + s2);

        }finally {
            service.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        new BedTime().countSheep();
    }
}

//23
class StockRoomTracker {
    public static void await(CyclicBarrier cb){
        try {
            cb.await();
        }catch(Exception e){

        }
    }

    public static void main(String[] args) {
        var cb = new CyclicBarrier(10, () -> System.out.println("Stock room full"));
        IntStream.iterate(1, i -> 1).limit(9).parallel().forEach(i -> await(cb));
    }
}

//24
class TicketManager {
    private int tickets;
    private static TicketManager instance;
    private TicketManager(){}
    static synchronized TicketManager getInstance(){
        if(instance == null)
            instance = new TicketManager();
        return instance;
    }
    public int getTicketCount(){
        return tickets;
    }
    public void addTickets(int value){
        tickets += value;
    }
    public void sellTickets(int value){
        synchronized (this){
            tickets -= value;
        }
    }
}



//25
class CountZooAnimals {
    public static void performCount(int animal){
    }
    public static void pintResults(Future<?> f){
        try {
            System.out.println(f.get(1, TimeUnit.DAYS));
        }catch (Exception e){
            System.out.println("Exception!");
        }
    }

    public static void main(String[] args) throws Exception{
        final var r = new ArrayList<Future<?>>();
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            for (int i = 0; i < 10; i++) {
                final int animal = i;
                r.add(service.submit(() -> performCount(animal)));
            }
            r.forEach(f -> pintResults(f));
        }finally {
            service.shutdown();
        }
    }
}