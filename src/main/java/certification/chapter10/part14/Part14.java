package certification.chapter10.part14;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.minBy;

public class Part14 {

    public static void main(String[] args) {

        //groupingBy
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = ohMy.collect(groupingBy(String::length)); //null key are not allowed
        System.out.println(map); //{5=[lions, bears], 6=[tigers]}

        var ohMy2 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map2 = ohMy2.collect(groupingBy(String::length, Collectors.toSet()));
        System.out.println(map2); //{5=[lions, bears], 6=[tigers]}

        var ohMy3 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map3 = ohMy3.collect(groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(map3); //{5=[lions, bears], 6=[tigers]}

        var ohMy4 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, List<String>> map4 = ohMy4.collect(groupingBy(String::length, TreeMap::new, Collectors.toList()));
        System.out.println(map4); //{5=[lions, bears], 6=[tigers]}

        //partitioningBy
        var ohMy5 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map5 = ohMy5.collect(Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map5); //{false=[tigers], true=[lions, bears]}

        var ohMy6 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> map6 = ohMy6.collect(Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
        System.out.println(map6); //{false=[], true=[lions, bears, tigers]}

        var ohMy7 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map7 = ohMy7.collect(groupingBy(String::length, Collectors.counting()));
        System.out.println(map7); //{5=2, 6=1}

        var ohMy8 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> map8 = ohMy8.collect(groupingBy(String::length, Collectors.mapping(s -> s.charAt(0), Collectors.minBy((a, b) -> a-b))));
        System.out.println(map8); //{5=Optional[b], 6=Optional[t]}

        var ohMy9 = Stream.of("lions", "tigers", "bears");
        var map9 = ohMy9.collect(groupingBy(String::length, mapping(s -> s.charAt(0), minBy((a,b) -> a-b))));
        System.out.println(map9); //{5=Optional[b], 6=Optional[t]}

    }
}