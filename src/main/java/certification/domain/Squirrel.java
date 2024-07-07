package certification.domain;

import java.util.Comparator;

public class Squirrel implements Comparable<Squirrel> {

    private int weight;
    private String species;

    public Squirrel(int weight, String species) {
        this.weight = weight;
        this.species = species;
    }

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

    @Override
    public String toString() {
        return "Squirrel{" +
                "weight=" + weight +
                ", species='" + species + '\'' +
                '}';
    }

    @Override
    public int compareTo(Squirrel o) {
        return this.species.compareTo(o.getSpecies());
    }
}
