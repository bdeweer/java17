package certification.chapter10.part8;

import java.util.OptionalDouble;
import java.util.function.DoubleSupplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Part8 {

    public static void main(String[] args) {

        var stream = IntStream.rangeClosed(1, 10);
        OptionalDouble optionalDouble = stream.average();

        optionalDouble.ifPresent(System.out::println); //5.5
        System.out.println(optionalDouble.getAsDouble()); //not get() 5.5

        DoubleSupplier doubleSupplier = () -> Double.NaN;
        System.out.println(optionalDouble.orElseGet(doubleSupplier)); //5/5

        LongStream longs = LongStream.of(5, 10);
        long sum = longs.sum();
        System.out.println(sum); //15

        DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
        //OptionalDouble min = doubles.min(); //Runs infinitely

    }
}
