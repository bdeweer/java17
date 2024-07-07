package certification.chapter10.part1;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionalTest {

    public static void main(String[] args) {

        //Optional.of(null); //NullPointerException at runtime

        System.out.println(average(90, 100)); //Optional[95.0]
        System.out.println(average()); //Optional.empty

        Optional<Double> opt = average(90, 100);

        if(opt.isPresent()){
            System.out.println(opt.get()); //95.0
        }
        opt.ifPresent(System.out::println); //95.0

        Consumer<Double> consumer1 = System.out::println;
        Consumer<Double> consumer2 = x -> System.out.println(x);

        opt.ifPresent(x -> System.out.println(x)); //95.0
        opt.ifPresent(consumer1); //95.0
        opt.ifPresent(consumer2); //95.0

        String value = null;
        Optional<String> optValue = value == null ? Optional.empty() : Optional.of(value);
        Optional<String> optValueE = Optional.ofNullable(value);

        System.out.println(optValue); //Optional.empty
        System.out.println(optValueE); //Optional.empty

        System.out.println(average().orElse(Double.NaN)); //NaN

        Supplier<Double> supplier = () -> Math.random();
        System.out.println(average().orElseGet(() -> Math.random()));
        System.out.println(average().orElseGet(supplier));

        //System.out.println(average().get()); //NoSuchElementException

        //System.out.println(average().orElseThrow()); //SoSuchElementException
        System.out.println(average().orElseThrow(() -> new RuntimeException("Exception")));

    }

    public static Optional<Double> average(int ... numbers){

        if(numbers.length == 0){
            return Optional.empty();
        }
        int sum = 0;
        for(Integer i : numbers)
            sum += i;
        return Optional.of((double)sum/numbers.length);
    }
}