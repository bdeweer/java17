package certification.chapter10.part15;

import java.util.List;
import java.util.stream.Collectors;

public class Part15 {

    static record Separations(String spaceSeparated, String commaSeparated){}

    public static void main(String[] args) {

        var list = List.of("x", "y", "z");
        Separations result = list
                .stream()
                .collect(
                        Collectors
                                .teeing(
                                        Collectors.joining(" "),
                                        Collectors.joining(","),
                                        (s,c) -> new Separations(s,c)
                                )
                )
                ;
        System.out.println(result); //Separations[spaceSeparated=x y z, commaSeparated=x,y,z]

    }
}
