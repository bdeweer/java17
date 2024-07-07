package certification.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortRabbits {

    static record Rabbit(int id){}

    public static void main(String[] args) {

        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit(3));
        rabbits.add(new Rabbit(1));

        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
        Collections.sort(rabbits, c);
        Collections.sort(rabbits, Comparator.comparingInt(Rabbit::id));
        Collections.reverse(rabbits);

        System.out.println(rabbits);
    }
}
