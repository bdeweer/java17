package certification.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Part13 {

    public static void main(String[] args) {

        var ducks = new ArrayList<Duck>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));
        Collections.sort(ducks); //Compile only if Duck implements Comparable
        System.out.println(ducks);

        Comparator<Duck> byWeight = new Comparator<Duck>() {
            @Override
            public int compare(Duck o1, Duck o2) {
                return o1.weight - o2.weight;
            }
        };

        Comparator<Duck> byWeightLambda = (d1, d2) -> d1.getWeight() - d2.getWeight();
        Comparator<Duck> byWeightLambda2 = Comparator.comparingInt(Duck::getWeight);

        Collections.sort(ducks, byWeightLambda);
        System.out.println(ducks);
    }

    static class Duck implements Comparable<Duck> {
        private String name;
        private int weight;

        public Duck(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Duck{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Duck o) {
            return name.compareTo(o.name);
        }
    }
}

