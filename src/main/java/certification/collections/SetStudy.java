package certification.collections;

import certification.domain.ComparableTask;
import certification.domain.Task;

import java.util.*;

public class SetStudy {

    public static void main(String[] args) {


        SortedSet<ComparableTask> tasks = new TreeSet<>();

        tasks.add(new ComparableTask("Go to beach"));
        tasks.add(new ComparableTask("Learn Java"));
        tasks.add(new ComparableTask("Learn Java"));

        System.out.println(tasks+"\n"); //Keep order

        Set<Task> unorderedTasks = new HashSet<>();
        unorderedTasks.add(new Task("Go to beach"));
        unorderedTasks.add(new Task("Learn Java"));
        System.out.println(unorderedTasks + "\n");

        Set<String> strings = new HashSet<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("f");
        strings.add("e");
        strings.add("x");
        strings.add("j");
        strings.add("r");
        strings.add("r");

        System.out.println(strings);

        Set<String> linkedHashSet = new LinkedHashSet<>(); //Guarantees to keep elements in the order in which they were first added
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        linkedHashSet.add("c");
        linkedHashSet.add("d");
        linkedHashSet.add("f");
        linkedHashSet.add("e");
        linkedHashSet.add("x");
        linkedHashSet.add("j");
        linkedHashSet.add("r");

        System.out.println("\n"+linkedHashSet);

        //Set<Character> letters = Set.of('z', 'o', 'o'); //IllegalArgumentException : duplicate element: o
        Set<Character> letters = Set.of('z', 'o'); //Create immutable Set
        Set<Character> copy = Set.copyOf(letters);

        System.out.println("\n"+letters);
        System.out.println(copy);

        Set<Integer> set = new HashSet<>();
        System.out.println("\n"+set.add(66)); //true
        System.out.println(set.add(10)); //true
        System.out.println(set.add(66)); //false
        System.out.println(set.add(8)+"\n"); //true

        set.forEach(System.out::println); //prints elements in an arbitrary order

        Set<Integer> treeSet = new TreeSet<>();
        System.out.println("\n"+treeSet.add(66)); //true
        System.out.println(treeSet.add(10)); //true
        System.out.println(treeSet.add(66)); //false
        System.out.println(treeSet.add(8)+"\n"); //true

        treeSet.forEach(System.out::println); //Print elements in their natural order

    }
}
