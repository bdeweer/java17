package certification.chapter13.part7;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTime {

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        //printHello(lock);
        new Thread(() -> printHello(lock)).start();
        //new Thread(() -> printHello(lock)).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(lock.tryLock(10, TimeUnit.SECONDS)){
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