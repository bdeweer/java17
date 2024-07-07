package certification.chapter9;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Part1 {

    public static void main(String[] args) {

        Set<Integer> set10 = new HashSet<>();
        set10.add(1);
        set10.add(2);
        set10.add(99);
        set10.add(3);
        set10.add(4);
        set10.add(5);
        set10.add(null);
        System.out.println(set10);
        set10.remove(20);

        //add and remove elements
        List<Integer> list = new ArrayList<>();


        boolean add = list.add(1);
        System.out.println(add); //true

        boolean removed = list.remove(Integer.valueOf(1)); //box int : true
        boolean removed2 = list.remove(Integer.valueOf(1)); //box int : false

        System.out.println(removed); //true
        System.out.println(removed2); //false

        System.out.println("-----------------------------------------------------------------------------------------");
        //counting element

        Collection<String> birds = new ArrayList<>();
        System.out.println(birds.isEmpty()); //true
        System.out.println(birds.size()); //0

        birds.add("hawk");
        birds.add("hawk");
        System.out.println(birds.isEmpty()); //false
        System.out.println(birds.size()); //2

        System.out.println("-----------------------------------------------------------------------------------------");

        //clearing the Collection
        birds.clear();
        System.out.println(birds.isEmpty()); //true
        System.out.println(birds.size()); //0

        System.out.println("-----------------------------------------------------------------------------------------");

        //check contents
        birds.add("hawk");
        System.out.println(birds.contains("hawk")); //equals() call - true
        System.out.println(birds.contains("robin")); //false

        System.out.println("----------------------------- ------------------------------------------------------------");

        //removing with conditions

        Collection<String> list2 = new ArrayList<>();
        list2.add("Magician");
        list2.add("Assistant");
        System.out.println(list2);

        Predicate<String> predicate = s -> s.startsWith("A");
        boolean removed3 = list2.removeIf(predicate); //removeIf on Collection interface
        System.out.println(removed3); //true
        System.out.println(list2); //[Magician]

        System.out.println("-------------------------------------------------------------");

        Collection<String> set = new HashSet<>();
        set.add("Wand");
        set.add("");
        set.removeIf(String::isEmpty);
        System.out.println(set); //[Wand]
        System.out.println("-----------------------------------------------------------------------------------------");


        //Iterating
        Collection<String> cats = List.of("Annie", "Ripley");
        cats.forEach(System.out::println); //Annie Ripley
        cats.forEach(c -> System.out.println(c)); //Annie Ripley

        for(String element : cats){
            System.out.println(element); //Annie Ripley
        }

        Iterator<String> iterator = cats.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()); //Annie Ripley
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        //Determining equality

        var list3 = List.of(1,2);
        var list4 = List.of(2,1);

        var set1 = Set.of(1,2);
        var set2 = Set.of(2,1);

        System.out.println(list3.equals(list4)); //false - ArrayList checks order
        System.out.println(set1.equals(set2)); //true - HashSet doesn't check order
        System.out.println(list3.equals(set1)); //false

        System.out.println("-----------------------------------------------------------------------------------------");

        //unboxing nulls
        var heights = new ArrayList<Integer>();
        heights.add(null);
        int h = heights.get(0); //NPE

    }
}
