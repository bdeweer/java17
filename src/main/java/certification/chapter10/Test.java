package certification.chapter10;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        System.out.println(Stream.iterate(1, x -> ++x).limit(5).map(x -> ""+x).collect(Collectors.joining()));
        ;

    }
}