package certification.chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Book {
    private String name;
    private String author;
    private int yearPublished;
}

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Integer> l1 = List.of(1,2,3,4);

        Stream<Integer> s1 = l1.parallelStream();
        Stream<Integer> s2 = l1.stream().parallel();

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        int sum = listOfNumbers.parallelStream().reduce(5, Integer::sum); //bug!
        System.out.println(sum);

        sum = listOfNumbers.parallelStream().reduce(0, Integer::sum) + 5; //ok
        System.out.println(sum);

        IntStream.range(1,10); //end exclusive
        IntStream.rangeClosed(1,10); //end inclusive

        IntStream.iterate(0, i -> i + 2).limit(10); //produit 10 valeurs

        ExecutorService service = Executors.newSingleThreadExecutor();

        var future = service.submit(() -> System.out.println("Test"));

        Object o = future.get();
        System.out.println(o);

        service.shutdown();

        ExecutorService service2 = Executors.newSingleThreadScheduledExecutor(); //Need to cast to call schedules methods
        //((ScheduledExecutorService)service2).schedule()

        var atomicLong = new AtomicLong(5);
        System.out.println(atomicLong);

        System.out.println("Fini");

        final int counter = 0;
        //Runnable r = () -> counter++; doest not compile

        //Liste modifiable
        List<String> couleurs1 = new ArrayList<>(Arrays.asList("Bleu", "Rouge", "Vert"));
        List<String> couleurs2 = new ArrayList<>(List.of("Bleu", "Rouge", "Vert"));

        Queue q;
        BlockingQueue bq;
        LinkedBlockingQueue lbq;
        ArrayBlockingQueue abqq;
    }
}
