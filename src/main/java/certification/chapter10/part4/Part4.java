package certification.chapter10.part4;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part4 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("w", "o", "l", "f");

        StringBuilder word = stream.collect(
                StringBuilder::new, //supplier
                StringBuilder::append, //accumulator (BiConsumer) : takes two parameters and doesn't return anything
                StringBuilder::append //combiner (BiConsumer) : takes two data collections and merging them. !in parallel, the order is not guarantee!
        );
        System.out.println(word.toString());

        Stream<String> stream1 = Stream.of("w", "o", "l", "f");

        TreeSet<String> set = stream1.collect(
                TreeSet::new, //creates an empty TreeSet
                TreeSet::add, //Add a single String from the Stream to the TreeSet (accumulator)
                TreeSet::addAll //Add all the elements of one TreeSet to another in case operations were done in // and need to be merged.
        );
        System.out.println(set); //Un TreeSet est trié

        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set2 = stream2.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set2);

        Stream<String> stream3 = Stream.of("w", "o", "l", "f");
        Set<String> set3 = stream3.collect(Collectors.toSet());
        System.out.println(set3);
    }
}