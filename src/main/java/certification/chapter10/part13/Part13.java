package certification.chapter10.part13;

import java.util.Map;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.TreeMap;

public class Part13 {

    public static void main(String[] args) {

        var ohMy = Stream.of("lions", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result); //lions, bears

        var ohMy2 = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result2 = ohMy2.filter(s -> s.startsWith("t")).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result2); //[tigers]

        //map
        var ohMy3 = Stream.of("lions", "tigers", "bears");

        Function<String, String> identity = Function.identity();
        Function<String, Integer> length = String::length;
        Map<String, Integer> map = ohMy3.collect(Collectors.toMap(identity, length));
        System.out.println(map); //{lions=5, bears=5, tigers=6}

        var ohMy4 = Stream.of("lions", "tigers", "bears");
        //Map<Integer, String> map2 = ohMy4.collect(Collectors.toMap(String::length, k -> k)); //Duplicate key
        //System.out.println(map2);

        var ohMy5 = Stream.of("lions", "tigers", "bears");
        BinaryOperator<String> mergeFunction = (s1, s2) -> s1 + "," + s2;
        Map<Integer, String> map3 = ohMy5.collect(Collectors.toMap(String::length, k -> k, mergeFunction));
        System.out.println(map3); //{5=lions,bears, 6=tigers}

        Supplier<TreeMap<Integer, String>> supplier = TreeMap::new;

        var ohMy6 = Stream.of("lions", "tigers", "bears");
        BinaryOperator<String> mergeFunction2 = (s1, s2) -> s1 + "," + s2;
        Map<Integer, String> map4 = ohMy6.collect(Collectors.toMap(String::length, k -> k, mergeFunction, supplier));
        System.out.println(map4); //{5=lions,bears, 6=tigers}
    }
}