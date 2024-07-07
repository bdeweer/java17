package certification.chapter9;

import java.util.*;

public class Part15 {

    static record Rabbit(int id){}

    public static void main(String[] args) {

        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit(3));
        rabbits.add(new Rabbit(1));

        //Collections.sort(rabbits); //does not compile

        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
        Collections.sort(rabbits, c);

        System.out.println(rabbits); //[Rabbit[id=1], Rabbit[id=3]]

        Collections.reverse(rabbits);
        System.out.println(rabbits); //[Rabbit[id=3], Rabbit[id=1]]

        System.out.println("-----------------------------------------------------------------------------------------");

        List<Integer> list = Arrays.asList(6,9,1,8);

        Collections.sort(list);
        System.out.println(list); //[1, 6, 8, 9]

        System.out.println(Collections.binarySearch(list, 6)); //prints the index at which a match is found => 1
        System.out.println(Collections.binarySearch(list, 3)); // -2 : would be inserted at index 1 -> -1 - 1 => -2

        System.out.println("-----------------------------------------------------------------------------------------");

        var names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c2 = Comparator.reverseOrder();
        var index = Collections.binarySearch(names, "Hoppy", c2);
        System.out.println(index); //result is undefined since the list is not sorted

        System.out.println("-----------------------------------------------------------------------------------------");

        Set<Duck> ducks = new TreeSet<>();
        ducks.add(new Duck("Puddles"));

        //Set<Rabbit> rabbits1 = new TreeSet<>();
        //rabbits1.add(new Rabbit(1)); //ClassCastException

        Set<Rabbit> rabbits2 = new TreeSet<>((r1, r2) -> r1.id - r2.id); //Pass a comparator to TreeSet constructor
        rabbits2.add(new Rabbit(1));

        System.out.println("-----------------------------------------------------------------------------------------");

        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");
        System.out.println(bunnies); //[long ear, floppy, hoppy]
        Collections.sort(bunnies);
        bunnies.sort(String::compareTo);
        System.out.println(bunnies); //[floppy, hoppy, long ear]
    }
}