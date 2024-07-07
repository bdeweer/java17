package certification.collections;

import certification.domain.Duck;
import certification.domain.Squirrel;

import java.util.*;

public class ComparatorStudy {

    public static void main(String[] args) {

        Comparator<String> sizeOrder = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() < o2.length() ? -1 :
                        o1.length() > o2.length() ? 1 :
                                o1.compareTo(o2);
            }
        };

        System.out.println("two".compareTo("three"));
        System.out.println(sizeOrder.compare("two", "three"));

        Collection<String> strings = Arrays.asList("from", "aaa", "to", "zzz");
        System.out.println(Collections.max(strings)); //zzz
        System.out.println(Collections.min(strings)); //aaa
        System.out.println(Collections.max(strings, sizeOrder)); //from
        System.out.println(Collections.min(strings, sizeOrder)); //to


        Comparator<Duck> byWeight = new Comparator<Duck>() {
            @Override
            public int compare(Duck o1, Duck o2) {
                return o1.getWeight()- o2.getWeight();
            }
        };

        var ducks = new ArrayList<Duck>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));

        Collections.sort(ducks);

        System.out.println(ducks);

        Collections.sort(ducks, byWeight);
        Collections.sort(ducks, (o1, o2) -> o1.getWeight() - o2.getWeight());
        Collections.sort(ducks, Comparator.comparingInt(Duck::getWeight)); //Comparator is a functional interface

        System.out.println(ducks);

        Comparator<Squirrel> multipleFieldComparator = new Comparator<Squirrel>() {
            @Override
            public int compare(Squirrel s1, Squirrel s2) {
                int result = s1.getSpecies().compareTo(s2.getSpecies());
                if(result != 0)return result;
                return s1.getWeight() - s2.getWeight();
            }
        };

        Comparator<Squirrel> c = (s1, s2) -> {
            int result = s1.getSpecies().compareTo(s2.getSpecies());
            if(result != 0)return result;
            return s1.getWeight() - s2.getWeight();
        };

        Comparator<Squirrel> c2 = Comparator.comparing(Squirrel::getSpecies).thenComparingInt(Squirrel::getWeight); //chaining comparator (ascending order by species)
        Comparator<Squirrel> c3 = Comparator.comparing(Squirrel::getSpecies).reversed().thenComparingInt(Squirrel::getWeight); //chaining comparator (descending order by species)

        Comparator<Squirrel> c4 = Comparator.reverseOrder();

    }

    static class MultiFieldComparator implements Comparator<Squirrel>{

        public int compare(Squirrel s1, Squirrel s2){
            int result = s1.getSpecies().compareTo(s2.getSpecies());
            if(result != 0)return result;
            return s1.getWeight() - s2.getWeight();
        }
    }
}
