package certification.chapter10.part6;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part6 {

    public static void main(String[] args) {


       /* Stream
                .generate(() ->"Elsa")
                .filter(n -> n.length() == 4)
                .sorted() //Impossible to sort an infinite stream...
                .limit(2)
                .forEach(System.out::println);*/


        Stream
                .generate(() ->"Elsa")
                .filter(n -> n.length() == 4)
                .limit(2)
                .sorted()
                .forEach(System.out::println);

      /*  Stream
                .generate(() ->"Olaf Lazisson")
                .filter(n -> n.length() == 4)
                .limit(2) //n'arrive jamais à 2 ... infinite
                .sorted()
                .forEach(System.out::println);*/

        long count = Stream
                .of("goldfish", "finch")
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList()).stream().count();
        System.out.println(count);

    }
}
