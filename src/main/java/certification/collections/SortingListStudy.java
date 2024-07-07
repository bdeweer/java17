package certification.collections;

import java.util.ArrayList;
import java.util.List;

public class SortingListStudy {

    public static void main(String[] args) {

        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");

        System.out.println(bunnies);

        bunnies.sort(((a,b) -> a.compareTo(b)));
        bunnies.sort((String::compareTo));

        System.out.println(bunnies);

    }
}