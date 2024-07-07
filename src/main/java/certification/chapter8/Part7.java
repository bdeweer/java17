package certification.chapter8;

import java.util.List;
import java.util.function.*;

public class Part7 {

    public static void main(String[] args) {

        Predicate<List> ex1 = x -> "".equals(x.get(0));
        Consumer<Long> ex2 = (Long l) -> System.out.println(l);
        BiPredicate<String, String> ex3 = (s1, s2) -> false;


        //Function<List<String>> ex4 = x -> x.get(0); //Function requires two args
        //UnaryOperator<Long> ex5 = (Long l) -> 3.14; //Return type is double instead of Long

        //Convenience methods

        //Predicate
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEggs = egg.and(brown);
        Predicate<String> otherEggs = egg.and(brown.negate());

        //Consumer (andThen)
        Consumer<String> c1 = x -> System.out.print("1 : " + x);
        Consumer<String> c2 = x -> System.out.println(", 2: " + x);

        System.out.println("-----------------------------------------------------------------------------------------");

        Consumer<String> combined = c1.andThen(c2);
        combined.accept("Annie");

        BiConsumer<String, Integer> biConsumer = (x,y) -> System.out.println("X : " + x + " - y : " + y);

        //Function(compose)
        Function<Integer, Integer> before = x -> x + 1;
        Function<Integer, Integer> after = x -> x * 2;

        IntFunction<Integer> intFunction = x -> x + 1;

        Function<Integer, Integer> combined2 = after.compose(before);
        System.out.println(combined2.apply(3)); //8, not 7!!

        System.out.println("-----------------------------------------------------------------------------------------");

    }
}
