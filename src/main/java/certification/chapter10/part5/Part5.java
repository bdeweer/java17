package certification.chapter10.part5;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part5 {

    public static void main(String[] args) {

        //filtering
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m")).forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        //removing duplicates
        Stream<String> s2 = Stream.of("duck", "duck", "goose", "duck");
        s2.distinct().forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        //Restricting by position - limit() and skip()
        UnaryOperator<Integer> unaryOperator = n -> n + 1;
        Stream<Integer> s3 = Stream.iterate(1, unaryOperator);

        s3.skip(5).limit(2).forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        //mapping values
        Stream<String> s4 = Stream.of("monkey", "gorilla", "bonobo");
        Function<String, Integer> function = String::length;
        s4.map(function).forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        //flat mapping values

        List<String> zero = List.of();
        var one = List.of("Bonobo");
        var two = List.of("Mama Gorilla", "Baby Gorilla");

        Stream<List<String>> animals = Stream.of(zero, one, two);

        //Function<List<String>, Stream<String>> function1 = m -> m.stream();
        Function<List<String>, Stream<String>> function1 = Collection::stream;

        animals.flatMap(function1).forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        //sorting (java uses natural ordering by default)
        Stream<String> s5 = Stream.of("brown-", "bear-");
        s5.sorted().forEach(System.out::println);

        Stream<String> s6 = Stream.of("brown-", "bear-");
        //s6.sorted(Comparator::reverseOrder); DOES NOT COMPILE
        //is the same than
        //s6.sorted(() -> Comparator.reverseOrder());
        //which takes a supplier which isn't compatible with sorted() signature
        s6.sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        //taking a peek
        var s7 = Stream.of("black bear", "brown bear", "grizzly");
        long count = s7.filter(x -> x.startsWith("b")).peek(System.out::println).count();
        System.out.println(count);
    }
}