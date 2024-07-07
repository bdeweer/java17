
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws IOException{

        Predicate<String> predicate = s -> s.length() >3;
        var stream = Stream.iterate("-", s -> !s.isEmpty(), (s) -> s + s);

        //var b1 = stream.allMatch(predicate);
        var b2 = stream.anyMatch(predicate);

        System.out.println(b2);
    }
}

interface Ready {
    static int first = 2;
    final short DEFAULT_VALUE = 10;
    GetSet go = new GetSet();
}

class GetSet implements Ready {
    int first = 5;
    static int second = DEFAULT_VALUE;

    public static void main(String[] args) {
        var r = new Ready(){};
        System.out.println(r.first);
        System.out.println(" " + second);
    }
}