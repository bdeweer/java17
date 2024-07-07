package certification.chapter8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class Part5 {

    public static void main(String[] args) {

        //Supplier<Integer> supplier4 = () -> 4;
        //        long i = supplier4.get();
        //        //Long j = supplier4.get();



        //static
        Converter methodRef = Math::round;
        Converter lambda = x -> Math.round(x);
        Converter lambdaX = x -> {return Math.round(x);}; // attention les ;

        //static methods
        Supplier<LocalDate> supplier = () -> LocalDate.now();
        Supplier<LocalDate> supplierRef = LocalDate::now;



        //instance method on a parameter
        Predicate<String> predicate = s -> s.isEmpty();
        Predicate<String> predicateRef = String::isEmpty;
        BiPredicate<String, String> predicate1 = (x,y) -> x.startsWith(y);
        BiPredicate<String, String> predicate2 = String::startsWith;

        Function<String, Integer> function = String::length;
        BiFunction<String, String, String> function1 = String::concat;
        BinaryOperator<String> binaryOperator = String::concat;


        //instance method on a particular object
        Consumer<String> consumer = a -> System.out.println(a);
        Consumer<String> consumerRef = System.out::println;

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> consumer1 = (s,a) -> map.put(s,a);
        BiConsumer<String, Integer> consumerRed = map::put;

        String hehe = "Test";
        Predicate<String> predicate3 = a -> hehe.startsWith(a);
        Predicate<String> predicate4 = hehe::startsWith;



        //constructor
        Supplier<StringBuilder> supplie2 = () -> new StringBuilder();
        Supplier<StringBuilder> supplierRef2 = StringBuilder::new;

        Supplier<ArrayList> supplier3 = () -> new ArrayList();
        Supplier<ArrayList> supplierRef3 = ArrayList::new;



        System.out.println("-----------------------------------------------------------------------------------------");
        //instance method on a particular object
        var str = "Zoo";
        StringStart methodRef2 = str::startsWith;
        StringStart lambda2 = s -> str.startsWith(s);
        System.out.println("-----------------------------------------------------------------------------------------");
        var str2 = "";
        StringChecker methodRef3 = str::isEmpty;
        StringChecker lambda3 = () -> str.isEmpty();
        System.out.println("-----------------------------------------------------------------------------------------");
        var str3 = "";
        //StringChecker lambda4 = () -> str.startsWith("Zoo"); //Impossible to turn into lambda.
        //StringChecker methodRef = str::startsWith; //Does not compile
        //StringChecker methodREf = str.::startWith("Zoo"); //Does not compile
        System.out.println("-----------------------------------------------------------------------------------------");
        //instance method parameter
        StringParameterChecker methodRef4 = String::isEmpty; //looks like static method but it isn't
        StringParameterChecker lambda4 = s -> s.isEmpty();
        System.out.println("-----------------------------------------------------------------------------------------");
        //constructor (constructor reference)
        EmptyStringCreator methodRef5 = String::new;
        EmptyStringCreator lambda5 = () -> new String("");
        var myString = methodRef5.create();
        System.out.println("-----------------------------------------------------------------------------------------");
        StringCopier methodRef6 = String::new;
        StringCopier lambda6 = x -> new String(x);

        var myString2 = methodRef6.copy("Zebra");
    }
}

interface Converter{
    long round(double num);
}

interface StringStart {
    boolean beginningCheck(String prefix);
}

interface StringChecker {
    boolean check();
}

interface StringParameterChecker {
    boolean check(String text);
}

interface EmptyStringCreator{
    String create();
}

interface StringCopier {
    String copy(String value);
}