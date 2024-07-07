package certification.chapter10;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Part16 {

    public static void main(String[] args) {

        Predicate<String> empty = String::isEmpty;
        Predicate<String> notEmpty = empty.negate();

        var result =
                Stream
                        .generate(() -> "")
                        .limit(10)
                        .filter(notEmpty)
                        //.collect(Collectors.toList()); //[]
                        .collect(Collectors.groupingBy(k -> k)) //{}
                        .entrySet()
                        .stream()
                        .map(Map.Entry::getValue)
                        .flatMap(Collection::stream)
                        .collect(Collectors.partitioningBy(notEmpty));
                        //.collect(Collectors.groupingBy(n -> n));

        System.out.println(result);

                double res = LongStream
                        .of(6L, 8L, 10L)
                        .mapToInt(x -> (int)x )
                        .boxed()
                        .collect(Collectors.groupingBy(x -> x, Collectors.toSet()))
                        .keySet()
                        .stream()
                        .collect(Collectors.averagingInt(x -> x));

        System.out.println(res);

        Predicate<String> pp = s -> s.length() > 3;
        var stream =
                Stream
                        .iterate(
                                "-",
                                s -> !s.isEmpty(),
                                (s) -> s + s)
                ;

    //    var b1 = stream.noneMatch(pp);
        var b2 = stream.anyMatch(pp);

        System.out.println(b2);
  //      System.out.println(b2);

       // stream.limit(5).forEach(System.out::println);

        Set<String> birds = Set.of("oriole", "flamingo");

        List.of(1,2,3).forEach(System.out::println);

    }
}