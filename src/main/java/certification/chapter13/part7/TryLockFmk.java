package certification.chapter13.part7;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class TryLockFmk {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        printHello(lock);
        new Thread(() -> printHello(lock)).start();
        //new Thread(() -> printHello(lock)).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(lock.tryLock()){
            try {
                System.out.println("Lock obtained, entering protected code");
            } finally {
                lock.unlock();
            }
        }
        else {
            System.out.println("Unable to acquire the lock, doing something else");
        }
    }

    public static void printHello(Lock lock) {

        try {
            lock.lock();

            System.out.println("Hello");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }finally {
            lock.unlock();
        }
    }
}

class Padlock {
    private Lock lock = new ReentrantLock();
    public void lockUp(){
        if(lock.tryLock()){
            lock.lock();
            System.out.println("Locked !");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        var gate = new Padlock();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> gate.lockUp()).start();
            Thread.sleep(1_000);
        }
    }
}

class TicketTaker {
    long ticketSold;
    final AtomicInteger ticketsTaken;

    public TicketTaker(){
        ticketSold=0;
        ticketsTaken=new AtomicInteger(0);
    }
    public void performJob(){
        IntStream.iterate(1, p-> p+1).parallel().limit(100).forEach(i -> ticketsTaken.getAndIncrement());

        IntStream.iterate(1, q -> q+1).parallel().limit(500).forEach(i -> ++ticketSold);

        System.out.println(ticketsTaken + " " + ticketSold);
    }

    public static void main(String[] args) {
        new TicketTaker().performJob();
    }
}