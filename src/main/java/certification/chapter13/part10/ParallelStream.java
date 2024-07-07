package certification.chapter13.part10;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {

    public static void main(String[] args) {

        Collection<Integer> collection = List.of(1,2);

        Stream<Integer> p1 = collection.stream().parallel();
        Stream<Integer> p2 = collection.parallelStream();

        System.out.println(Runtime.getRuntime().availableProcessors());

        long start = System.currentTimeMillis();
        List.of(1,2,3,4,5).parallelStream().map(ParallelStream::doWork).forEachOrdered(s -> System.out.println(s + " "));
        System.out.println();
        var timeTaken = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Time: " + timeTaken + " seconds");
    }

    private static int doWork(int input){
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e){

        }
        return input;
    }
}
