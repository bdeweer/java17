package certification.chapter13;

import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class Question {
}

class StockRoomTracker {
    public static void await(CyclicBarrier cb){
        try {
            cb.await();
        }catch (Exception e ){

        }

    }

    public static void main(String[] args) {

        var cb = new CyclicBarrier(10, () -> System.out.println("Stock Room Full!"));
        IntStream.iterate(1, i -> 1).limit(9).parallel().forEach(i -> await(cb));
    }
}
