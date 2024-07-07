package certification.chapter8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.*;

public class Part6 {

    public static void main(String[] args) {

        Function<Double, Long> f = Math::round;
        f.apply(4.3);

        //Supplier
        Supplier<LocalDate> s1 = LocalDate::now; //static method reference
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        System.out.println(s1.get());
        System.out.println(s2.get());

        Supplier<StringBuilder> s3 = StringBuilder::new; //Constructor reference
        Supplier<StringBuilder> s4 = () -> new StringBuilder();

        System.out.println(s3.get());
        System.out.println(s4.get());

        Supplier<ArrayList<String>> s5 = ArrayList::new;
        System.out.println(s5.get());

        System.out.println("-----------------------------------------------------------------------------------------");
        //Consumer and BiConsumer
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);

        c1.accept("Jiro");
        c2.accept("Jiro");

        var map = new HashMap<String, Integer>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k,v) -> map.put(k,v);

        b1.accept("chicken", 7);
        b2.accept("chick", 1);

        System.out.println(map);

        var map2 = new HashMap<String, String>();
        BiConsumer<String, String> b3 = map2::put;
        BiConsumer<String, String> b4 = (k,v) -> map2.put(k,v);

        b3.accept("chicken", "Cluck");
        b4.accept("chick", "Tweep");

        System.out.println(map2);

        System.out.println("-----------------------------------------------------------------------------------------");
        //Predicate and BiPredicate
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();

        System.out.println(p1.test(""));
        System.out.println(p2.test(""));

        BiPredicate<String, String> bp1 = String::startsWith;
        BiPredicate<String, String> bp2 = (x,y) -> x.startsWith(y);

        System.out.println(bp1.test("chicken", "chick"));
        System.out.println(bp2.test("chicken", "chick"));

        System.out.println("-----------------------------------------------------------------------------------------");
        //Function and BiFunction
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();

        System.out.println(f1.apply("cluck"));
        System.out.println(f2.apply("cluck"));

        BiFunction<String, String, String> bf1 = String::concat;
        BiFunction<String, String, String> bf2 = (x,y) -> x.concat(y);

        System.out.println(bf1.apply("baby", "chick"));
        System.out.println(bf2.apply("baby", "chick"));

        System.out.println("-----------------------------------------------------------------------------------------");
        //UnaryOperator(extends Function) and BinaryOperator(extends BiFunction)

        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();

        System.out.println(u1.apply("jiro"));
        System.out.println(u2.apply("jiro"));

        BinaryOperator<String> bo1 = String::concat;
        BinaryOperator<String> bo2 = (x,y) -> x.concat(y);

        System.out.println(bo1.apply("baby", "chick"));
        System.out.println(bo2.apply("baby", "chick"));
    }
}