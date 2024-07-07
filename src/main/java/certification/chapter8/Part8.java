package certification.chapter8;

import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.Predicate;

public class Part8 {

    public static void main(String[] args) {
        //BooleanSupplier

        BooleanSupplier b1 = () -> true;
        BooleanSupplier b2 = () -> Math.random() > .5;

        System.out.println(b1.getAsBoolean());
        System.out.println(b2.getAsBoolean());

        System.out.println("-----------------------------------------------------------------------------------------");

        var d = 1.0;
        DoubleToIntFunction f1 = x -> 1;
        int v = f1.applyAsInt(d);
        System.out.println(v);

        System.out.println("-----------------------------------------------------------------------------------------");

        //All the sames
        Predicate<String> p1 = x -> true;
        Predicate<String> p2 = (var x) -> true;
        Predicate<String> p3 = (String x) -> true;

    }

    public void whatAmI() {
        consume((var x) -> System.out.println(x), 123);
    }

    public void consume(Consumer<Integer> c, int num){

        c.accept(num);
    }

    public void counts(List<Integer> list){
        list.sort((var x, var y) -> x.compareTo(y));
    }

    /*public void variables(int a){
        int b = 1;
        Predicate<Integer> p1 = a -> {
            int b = 0;
            int c = 0;
            return b == c;
        }; //Don't forget this ; !!!!!
    }*/
}
