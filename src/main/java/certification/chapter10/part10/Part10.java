package certification.chapter10.part10;

import java.util.ArrayList;
import java.util.Optional;

public class Part10 {

    public static void main(String[] args) {

        var cats = new ArrayList<String>();
        cats.add("Annie");
        cats.add("Ripley");
        var stream = cats.stream();
        cats.add("KC");
        System.out.println(stream.count()); //3

        length(Optional.of("Java")).ifPresent(System.out::println); //4
    }

    private static void threeDigit(Optional<Integer> optional){

        optional
                .map(n -> ""+n)
                .filter(n -> n.length() == 3)
                .ifPresent(System.out::println)
        ;
    }

    private static Optional<Integer> length(Optional<String> name){

        return
               // name.map(String::length);
                 //name.map(ChainingOptionals::calculator); //not good
                name.flatMap(ChainingOptionals::calculator);
    }

    private class ChainingOptionals {

        public static Optional<Integer> calculator(String v){
            return Optional.of(v.length());
        }
    }
}