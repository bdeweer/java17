package certification.chapter13.part11;

import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public class Collect {

    public static void main(String[] args) {

        Stream<String> stream =
                Stream
                        .of("w","o", "l", "f")
                        .parallel();

        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);

        System.out.println(set);
    }
}
