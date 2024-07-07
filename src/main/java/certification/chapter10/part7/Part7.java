package certification.chapter10.part7;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.function.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Part7 {

    public static void main(String[] args) {


        Stream<Integer> stream = Stream.of(1,2,3);
        System.out.println(stream.reduce(0, (a,b) -> a + b)); //6

        Stream<Integer> stream2 = Stream.of(1,2,3);
        System.out.println(stream2.mapToInt(x -> x).sum()); //int : 6

        //average
        IntStream intStream = IntStream.of(1, 2, 3);
        OptionalDouble avg = intStream.average();
        System.out.println(avg.getAsDouble()); //2.0

        //empty primitive streams
        DoubleStream empty = DoubleStream.empty();

        //one value
        DoubleStream oneValue = DoubleStream.of(3.14);
        oneValue.forEach(System.out::println); //3.14

        DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
        varargs.forEach(System.out::println); //1.0 1.1 1.2

        //infinite streams
        var random = DoubleStream.generate(Math::random);
        var fractions = DoubleStream.iterate(.5, d -> d/2);
        random.limit(3).forEach(System.out::println);
        fractions.limit(3).forEach(System.out::println); //0.5 0.25 0.125

        //count
        IntStream count = IntStream.iterate(1, n -> n + 1).limit(5);
        count.forEach(System.out::println); //1 2 3 4 5

        //beter
        IntStream range = IntStream.range(1,6);//6 is exclusive
        range.forEach(System.out::println); //1 2 3 4 5

        IntStream inclusive = IntStream.rangeClosed(1,5);
        inclusive.forEach(System.out::println); //1 2 3 4 5


        //mapping streams
        Stream<String> objStream = Stream.of("penguin", "fish");
        ToDoubleFunction<String> toDoubleFunction = String::length;
        ToIntFunction<String> toIntFunction = s -> s.length();
        ToLongFunction<String> toLongFunction = s -> s.length();

        DoubleStream douleStream1 = Stream.of("penguin", "fish").mapToDouble(toDoubleFunction); //String::length //type is ToIntFunction
        IntStream intStream1 = Stream.of("penguin", "fish").mapToInt(toIntFunction);
        LongStream longStream1 = Stream.of("penguin", "fish").mapToLong(toLongFunction);

        Stream<String> s1 = Stream.of("penguin", "fish");
        Function<String, String> function = Function.identity();
        Stream<String> s2 = s1.map(function);

        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);

        DoubleFunction<String> doubleFunction = x -> String.valueOf(x); //D'un Double vers un String
        DoubleUnaryOperator doubleUnaryOperator = x -> x; //D'un Double vers un Double
        DoubleToIntFunction doubleToIntFunction = x -> (int)x; //D'un Double vers un Int
        DoubleToLongFunction doubleToLongFunction = x -> (long)x; //D'un Double vers un Long

        IntStream intStream2 = IntStream.of(1, 2, 3);

        IntFunction<String> intFunction = x -> String.valueOf(x); //D'un int vers un String
        IntToDoubleFunction intToDoubleFunction = x -> x; //D'un int vers un double
        IntUnaryOperator intUnaryOperator = x -> (int)x; //D'un int vers un Int
        IntToLongFunction intToLongFunction = x -> (long)x; //D'un int vers un Long

        intStream2.mapToObj(intFunction);
        //intStream2.mapToDouble(intToDoubleFunction);
        //intStream2.map(intUnaryOperator);
        //intStream2.mapToLong(intToLongFunction);


        LongStream longStream2 = LongStream.of(1L, 2L, 3L);

        LongFunction<String> longFunction = x -> String.valueOf(x); //D'un long vers un String
        LongToDoubleFunction longToDoubleFunction = x -> x; //D'un long vers un double
        LongToIntFunction longToIntFunction = x -> (int)x; //D'un long vers un Int
        LongUnaryOperator longUnaryOperator = x -> (long)x; //D'un long vers un Long

        longStream2.mapToObj(longFunction);
        //longStream2.mapToObj(x -> x);
        //longStream2.mapToDouble(longToDoubleFunction);
        //longStream2.mapToInt(longToIntFunction);
        //longStream2.map(longUnaryOperator);


        //2 autres techniques

        Stream<Integer> stream1 = IntStream.of(1,2,3,4).mapToObj(x -> x);
        Stream<Integer> stream3 = IntStream.of(1,2,3,4).boxed();


        //using flatmap

        var integerList = new ArrayList<Integer>();
        IntStream ints = integerList.stream().flatMapToInt(x -> IntStream.of(x)); //ou IntStream::of
        DoubleStream doubles = integerList.stream().flatMapToDouble(x -> DoubleStream.of(x)); //ou IntStream::of
        LongStream longs = integerList.stream().flatMapToLong(x -> LongStream.of(x)); //ou IntStream::of
    }
}