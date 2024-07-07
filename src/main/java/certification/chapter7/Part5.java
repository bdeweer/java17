package certification.chapter7;

public class Part5 {
}

interface Herbivore {
    public void eatPlants();
}

interface Omnivore {
    public void eatPlants();
}

class Bear implements Herbivore, Omnivore {

    @Override
    public void eatPlants() { //accept covariant return type

        System.out.println("eatPlants");
    }

    public static void main(String[] args) {

        Omnivore herbivore = new Bear();
        herbivore.eatPlants();
    }
}
