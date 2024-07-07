package certification.chapter10.part2;

import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Part2 {

    public static void main(String[] args) {

        //finite streams

        Stream<Object> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1,2,3);

        Stream.of(new int []{1,2});

        var list = List.of(1,2,3);
        Stream<Integer> fromList = list.stream();
        Stream<Integer> fromListParallel = list.parallelStream();
        Stream<Integer> fromListParallel2 = list.stream().parallel();

        //infinite streams
        Stream<Double> randoms = Stream.generate(Math::random); //() -> Math.random()

        UnaryOperator<Integer> unaryOperator = n -> n + 2;
        IntUnaryOperator intUnaryOperator = n -> n + 2;

        Stream<Integer> oddNumbers1 = Stream.iterate(1, n -> n + 2);
        Stream<Integer> oddNumbers2 = Stream.iterate(1, unaryOperator);

        Predicate<Integer> predicate = x -> x <=100;

        Stream<Integer> oddNumberUnder100 = Stream.iterate(1, predicate, unaryOperator);
        oddNumberUnder100.forEach(System.out::println);
    }
}