package certification.chapter8;

import com.sun.management.UnixOperatingSystemMXBean;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class Test {
}


class Panda {
    int age;

    public static void main(String[] args) {
        Panda panda = new Panda();
        panda.age = 1;
        check(panda, p -> p.age < 5);

        System.out.println("-----------------------------------------------------------------------------------------");

        Secret s = new MySecret();
        Secret s2 = (e) -> "Proof";
        Secret s3 = (e) -> {String f = ""; return "Proof";};

        System.out.println("-----------------------------------------------------------------------------------------");

        BooleanSupplier booleanSupplier = () -> true;
        DoubleSupplier doubleSupplier = () -> 4d;
        IntSupplier intSupplier = () -> 4;

        System.out.println("-----------------------------------------------------------------------------------------");

        UnaryOperator<Integer> u = x -> x * x;
        BinaryOperator<Integer> f = (x,y) -> x * x; //trap! only one generic!
        Function<Integer, Integer> f1 = x -> x*x;

        System.out.println("-----------------------------------------------------------------------------------------");

        Function<Integer, Integer> s4 = a -> a + 4;
        Function<Integer, Integer> s5 = a -> a * 3;
        Function<Integer, Integer> s6 = s4.compose(s5);
        System.out.println(s6.apply(1)); //7

        System.out.println("-----------------------------------------------------------------------------------------");
        int legnth = 3;
        for (int i = 0; i < 3; i++) {
            if(i%2==0){
                Supplier<Integer> supplier = () -> legnth;
                System.out.println(supplier.get());
            }else {
                int j = i;
                Supplier<Integer> supplier = () -> j;
                System.out.println(supplier.get());
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        Supplier<String> supplier = String::new;
        BiConsumer<String, String> biConsumer;
        UnaryOperator<String> unaryOperator = a -> a + a;

        System.out.println("-----------------------------------------------------------------------------------------");
        Set<?> set = Set.of("lion", "tiger", "bear");
        var copy = Set.copyOf(set);
        Consumer<Object> consumer = System.out::println;
        Consumer<Object> consumer2 = ss -> System.out.println(ss);
        Consumer<Object> consumer3 = (ss) -> System.out.println(ss);
        consumer.accept(set);
        consumer2.accept(set);
        consumer3.accept(set);
        copy.forEach(consumer);
        copy.forEach(consumer2);
        copy.forEach(consumer3);

        System.out.println("-----------------------------------------------------------------------------------------");

        int length = 3;

        for (int i = 0; i < 3; i++) {
            if(i%2 == 0){
                Supplier<Integer> supplier1 = () -> legnth;
                System.out.println(supplier1.get());
            }
            else {
                int j=i;
                Supplier<Integer> supplier1 = () -> j;
                System.out.println(supplier1.get());
            }
        }



    }

    private static void check(Panda panda, Predicate<Panda> pred){
        String result = pred.test(panda) ? "match" : "not match";
        System.out.println(result);
    }

    public static void method(){

        x((var x) -> {}, (var x, var y) -> false); //compiles!!

    }

    public static void x(Consumer<String>x, BinaryOperator<Boolean> y){}

    public void remove(List<Character> chars){
        char end = 'z';
        Predicate<Character> predicate = c -> {
            char start = 'a';
            return start <= c && c <= end;
        };

        char start = 'a';
        char c = 'x';
        chars = null;
    }

    public static void remove2(List<Character> chars){
        char end = 'z';
        //chars = null;

        Predicate<Character> predicate = c -> {
            char start = 'a'; return start <= c && c <= end;
        };

        char start = 'a';
        char c = 'x';
        chars = null;
        //end = '1';
    }
}

interface Secret {
    String magic(double d);
}

class MySecret implements Secret {
    public String magic(double d){
        return "Proof";
    }
}

class Fantasy {
    public static void scary(String animal){
        //does not compile!!
        //var dino = s -> "dino".equals(animal);
        //var dragon = s -> "dragon".equals(animal);
        //var combined = dino.or(dragon);
    }
}


class Hyena {
    private int age = 1;

    public static void main(String[] args) {
        var p = new Hyena();
        double height = 10;
        int age = 1;
        testLaugh(p, var -> p.age <= 10); //compiles!!!!
        testLaugh(p, h -> h.age < 5);
        age =2;

    }

    static void testLaugh(Hyena panda, Predicate<Hyena> joke){
        var r = joke.test(panda) ? "ahahaha" : "silence";
        System.out.println(r);
    }
}

class Panda2 {

    int age;

    public static void main(String[] args) {

        Panda2 panda2 = new Panda2();
        panda2.age = 1;
        //check(panda2, p -> {p.age < 5}); compilation error
    }

    private static void check(Panda2 panda2, Predicate<Panda2> pred){
        String result = pred.test(panda2) ? "match" : "not match";
        System.out.println(result);
    }
}



interface Yawn {
    String yawn(double d, List<Integer> time);
}

class Sloth implements Yawn{
    @Override
    public String yawn(double zzz, List<Integer> time) {
        return "Sleep : " + zzz;
    }
}

class Vet {
    private String name= "Jiro";
    public static String takeNap(Yawn y){
        return y.yawn(10, null);
    }

    public static void main(String[] args) {
        System.out.print(takeNap(new Sloth()));
        System.out.println(takeNap((a,b) -> "Sleep: " + (double)(b==null ? a : a)));

        Function<Integer, Integer> s = a -> a + 4;
        Function<Integer, Integer> t = a -> a * 3;
        Function<Integer, Integer> c = s.compose(t);
        System.out.println(c.apply(1)); //7 !!
    }

    public void variables(int a){
        //int b=1;

        Predicate<Integer> p1 = z -> {
            z+=4;
            System.out.println("a : " + a + "name : " + name);
            int b = 0;
            int c = 0;
            return b == c && z == 1;
        };

    }
}

interface Climb {
    boolean isTooHigh(int height, int limit);
}

