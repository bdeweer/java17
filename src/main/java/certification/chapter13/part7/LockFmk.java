package certification.chapter13.part7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFmk {

    public static void main(String[] args) {


        Object object = new Object();
        synchronized (object){
            //Protected code
        }

        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            //Protected code
        }
        finally {
            lock.unlock();
        }
    }
}
