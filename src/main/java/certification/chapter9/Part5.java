package certification.chapter9;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Part5 {

    public static void main(String[] args) {

        Set<Character> letters = Set.of('z', 'o');
        Set<Character> copy = Set.copyOf(letters);

        System.out.println(letters); //[o, z]
        System.out.println(copy); //[o, z]

        System.out.println("-----------------------------------------------------------------------------------------");

        //HashSet
        Set<Integer> set = new HashSet<>();
        boolean b1 = set.add(66); //true
        boolean b2 = set.add(10); //true
        boolean b3 = set.add(66); //false
        boolean b4 = set.add(8); //true
        boolean b4bis = set.add(null);

        set.forEach(System.out::println); //prints element in an arbitrary order

        System.out.println("-----------------------------------------------------------------------------------------");

        //TreeSet
        Set<Integer> treeSet = new TreeSet<>();

        boolean b5 = treeSet.add(66); //true
        boolean b6 = treeSet.add(10); //true
        boolean b7 = treeSet.add(66); //false
        boolean b8 = treeSet.add(8); //true
        //boolean b9 = treeSet.add(null); //NullPointerException

        treeSet.forEach(System.out::println); //prints element in their natural order (Number implements Comparable)


        var incomparableSet = new TreeSet<>();
        //incomparableSet.add(new Incomporable()); //ClassCastException

    }
}

class Incomporable {}