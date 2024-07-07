package certification.chapter10.part12;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class Part12 {

    public static void main(String[] args) throws Exception{

        //Spliterator with list

        var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-", "mouse-");

        Spliterator<String> originalBag = stream.spliterator();

        System.out.println(originalBag.estimateSize()); //7

        Spliterator<String> emmasBag = originalBag.trySplit();

        System.out.println(originalBag.estimateSize()); //4

        System.out.println(emmasBag.estimateSize()); //3

        //System.out.println("original :");
      //  originalBag.forEachRemaining(System.out::println);

        System.out.println("emmas : ");
        emmasBag.forEachRemaining(System.out::println);

        System.out.println("\njills bag : ");
        Spliterator<String> jillsBag = originalBag.trySplit();
        jillsBag.tryAdvance(System.out::println);
        System.out.println(jillsBag.estimateSize());
        System.out.println("For each remaining");
        jillsBag.forEachRemaining(System.out::println);

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");

        //Spliterator with stream

        var originalBagStream = Stream.iterate(1, n -> ++n).spliterator();

        Spliterator<Integer> newBag = originalBagStream.trySplit();

        System.out.println(newBag.estimateSize()); //1024

        newBag.tryAdvance(System.out::println); //1
        newBag.tryAdvance(System.out::println); //2
        newBag.tryAdvance(System.out::println); //3

        originalBagStream.tryAdvance(System.out::println); //1025
        originalBagStream.tryAdvance(System.out::println); //1026
        originalBagStream.tryAdvance(System.out::println); //1027

        System.out.println(Stream.generate(Math::random).spliterator().estimateSize());

    }
}
