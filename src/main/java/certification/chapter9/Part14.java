package certification.chapter9;

import java.util.Comparator;

public class Part14 {

    public static void main(String[] args) {
        //Multiple fields comparator
        Comparator<Squirrel> c =
                Comparator
                        .comparing(Squirrel::getSpecies)
                        .thenComparingInt(Squirrel::getWeight);

        // Reverse comparator
        var c2 = Comparator.comparing(Squirrel::getSpecies).reversed();
    }
}

class Squirrel {

    private int weight;
    private String species;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Squirrel(int weight, String species) {
        this.weight = weight;
        this.species = species;
    }

    @Override
    public String toString() {
        return "Squirrel{" +
                "weight=" + weight +
                ", species='" + species + '\'' +
                '}';
    }
}