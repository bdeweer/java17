package certification.collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetStudy {

    public static void main(String[] args) {

        SortedSet<Integer> sset = new TreeSet<>();
        sset.add(2);
        sset.add(10);
        sset.add(4);
        sset.add(3);
        sset.add(1);

        System.out.println("content of sorted set : " + sset);
        System.out.println("first element in set : " + sset.first());
        System.out.println("last element in set : " + sset.last());
        System.out.println("element before number 4 : " + sset.headSet(4));
        System.out.println("element after number 4 : " + sset.tailSet(4)); //including 4
        System.out.println("element between 2 and 4 : " + sset.subSet(2, 4)); //including 2

        //Data structures that involve sorting do not allow null values
        sset.add(null); //runtime exception

    }
}
