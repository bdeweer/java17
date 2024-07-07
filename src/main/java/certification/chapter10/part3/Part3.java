package certification.chapter10.part3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Part3 {

    public static void main(String[] args) {

        //count on finite stream
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s.count()); //3

        //count on infinite stream
        Stream<Double> s2 = Stream.generate(Math::random);
        //System.out.println(s2.count());

        //min - max
        Stream<String> s3 = Stream.of("monkey", "ape", "bonobo");
        Comparator<String> comparator = (a,b) -> a.length() - b.length();
        Comparator<String> comparator2 = Comparator.comparingInt(String::length);

        Optional<String> min = s3.min(comparator);
        min.ifPresent(System.out::println); //ape

        //The stream is empty, the comparator isn't called
        Optional<?> minEmpty = Stream.empty().min((ss1,ss2) -> ss1.toString().length() - ss2.toString().length()); //Not a NPE!
        System.out.println(minEmpty.isPresent()); //false

        Optional<?> maxOpt = Stream.of(1,6,3,8,2).max((y,z) -> y-z);
        maxOpt.ifPresent(System.out::println); //8

        System.out.println("-----------------------------------------------------------------------------------------");

        //finding value - findAny() findFirst() - Can terminate with an infinite stream
        Stream<String> s4 = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");

        s4.findAny().ifPresent(System.out::println); //monkey
        infinite.findAny().ifPresent(System.out::println); //chimp

        Stream.of("monkey", "gorilla", "bonobo").findFirst().ifPresent(System.out::println); //monkey
        Stream.generate(() -> "chimp").findFirst().ifPresent(System.out::println); //chimp

        System.out.println("-----------------------------------------------------------------------------------------");
        //matching - allMatch(), anyMatch(), noneMatch()

        Predicate<String> predicate = x -> Character.isLetter(x.charAt(0));

        System.out.println(List.of("monkey", "2", "chimp").stream().anyMatch(predicate)); //true
        System.out.println(List.of("monkey", "2", "chimp").stream().allMatch(predicate)); //false
        System.out.println(List.of("monkey", "2", "chimp").stream().noneMatch(predicate)); //false
        System.out.println(Stream.generate(() -> "chimp").anyMatch(predicate)); //true
        //System.out.println(Stream.generate(() -> "chimp").allMatch(predicate)); //infinite
        //System.out.println(Stream.generate(() -> "chimp").noneMatch(predicate)); //infinite

        System.out.println("-----------------------------------------------------------------------------------------");

        //reducing
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        BinaryOperator<Integer> binaryOperator = (x,y) -> x + y;
        BinaryOperator<Integer> binaryOperator2 = Integer::sum;

        BinaryOperator<String> binaryOperator3 = (x,y) -> x + y;
        BinaryOperator<String> binaryOperator4 = String::concat;

        String word = stream.reduce("", binaryOperator3);
        System.out.println(word); //wolf

        Optional<String> wordOpt = Stream.of("w", "o", "l", "f").reduce( binaryOperator3);
        wordOpt.ifPresent(System.out::println);

        BinaryOperator<Integer> binaryOperatorMultiply = (x,y) -> x * y;

        Stream<Integer> streamInt = Stream.of(3,5,6);
        System.out.println(streamInt.reduce(1, binaryOperatorMultiply)); //90

        Stream<Integer> emptyStream = Stream.empty();
        Stream<Integer> oneElement = Stream.of(1);
        Stream<Integer> threeElements = Stream.of(3,5,7);

        //No identity : Optional returned
        System.out.println(emptyStream.reduce(binaryOperatorMultiply)); //Optional.empty
        System.out.println(oneElement.reduce(binaryOperatorMultiply)); //Optional[1]
        System.out.println(threeElements.reduce(binaryOperatorMultiply)); //Optional[105]

        Stream<String> stream1 = Stream.of("w", "o", "l", "f!");
        BiFunction<Integer, String, Integer> biFunction = (i,j) -> i + j.length();
        int length = stream1.reduce(0, biFunction, binaryOperator); //useful for // stream
        System.out.println(length); //5
    }
}