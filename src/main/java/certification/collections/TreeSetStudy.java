package certification.collections;

import certification.domain.Duck;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetStudy {

    static class Rabbit {
        int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Set<Duck> ducks = new TreeSet<>();
        ducks.add(new Duck("Puddles"));

        //Set<Rabbit> rabbits = new TreeSet<>();
        //rabbits.add(new Rabbit()); //ClassCastException at runtime

        //Set<Rabbit> rabbits = new TreeSet<>((r1, r2) -> r1.id - r2.id);
        //Set<Rabbit> rabbits = new TreeSet<>(Comparator.comparingInt(r -> r.id));
        Set<Rabbit> rabbits = new TreeSet<>(Comparator.comparingInt(Rabbit::getId));
        rabbits.add(new Rabbit());
    }
}
