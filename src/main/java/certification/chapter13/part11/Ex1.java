package certification.chapter13.part11;

import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1 {

    public static void main(String[] args) {

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map = ohMy.collect(Collectors.toConcurrentMap(String::length, k -> k, (s1, s2) -> s1+"," + s2));
        System.out.println(map);
        System.out.println(map.getClass());


    }
}
