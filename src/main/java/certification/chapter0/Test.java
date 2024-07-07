package certification.chapter0;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {


    public static void main(String[] args) {

        var treeMap = new TreeMap<Character, Integer>();

        treeMap.put('k', 1);
        treeMap.put('k', 2);
        treeMap.put('m', 3);
        treeMap.put('M', 4);

        treeMap.replaceAll((k,v) -> v + v);


        treeMap.keySet().forEach(k -> System.out.println(treeMap.get(k)));

    }
}

class Var {}
