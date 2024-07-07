package tests.practice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Gen {

    public static void main(String[] args) {

        int [] nums [] = new int [2][1];

      //  int [] nums2 [] = new int {};

    }

    public  void throwOne(Collection<? super RuntimeException> coll){
        var iter = coll.iterator();
        if(iter.hasNext())
        //throw iter.next();
            System.out.println("");
    }
}


class Snoopy {
    public static void main(String[] s) {

        var ss = Stream.of("speak", "bark", null, "grown");

        BinaryOperator<String> merge = (a,b) -> a;
        var map = ss.collect(Collectors.toMap(String::length, k->k, merge));
        System.out.println(map);
    }
}

class Concat {
    public String concat1(List<String> values){
        return values.parallelStream().reduce("a", (x,y) -> x+y, String::concat);
    }

    public String concat2(List<String> values){

        return values.parallelStream().reduce((x,y) -> y + x).get();
    }

    public static void main(String[] args) {


    }
}

class Speaking {


}

record Sorted(int num, String text) implements Comparable<Sorted>, Comparator<Sorted>{

    public String toString(){
        return ""+num;
    }

    @Override
    public int compareTo(Sorted o) {
        return text.compareTo(o.text);
    }

    @Override
    public int compare(Sorted o1, Sorted o2) {
        return o1.num - o2.num;
    }

    public static void main(String[] args) {

    }
}


interface Speak1 {
    public default int getVolume(){
        return 20;
    }
}


interface Whisper1 {
    public default int getVolume(){
        return 10;
    }
}

