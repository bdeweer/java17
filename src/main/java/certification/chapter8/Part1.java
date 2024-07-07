package certification.chapter8;

import java.util.List;

public class Part1 {

    public static void main(String[] args) {

        Animal jiro = new Animal("Shiba", true, false);
        Animal fifi = new Animal("Canari", false, true);

        CheckIfHopper checkIfHopper = new CheckIfHopper();
        printLegacy(List.of(jiro, fifi), checkIfHopper);
        System.out.println("-----------------------------------------------------------------------------------------");
        print(List.of(jiro, fifi), a -> a.canHop());
        System.out.println("-----------------------------------------------------------------------------------------");

        CheckTrait checkTrait = (Animal a) -> a.canHop();
        //var invalid = (Animal a) -> a.canHop();
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    private static void printLegacy(List<Animal> animals, CheckTrait checker){
        for(Animal animal : animals){
            if(checker.test(animal)){
                System.out.println(animal + " ");
            }
        }
    }

    private static void print(List<Animal> animals, CheckTrait checker){
        for(Animal animal : animals){
            if(checker.test(animal)){
                System.out.println(animal + " ");
            }
        }
    }
}

record Animal(String species, boolean canHop, boolean canSwim) {
}

interface CheckTrait{
    boolean test(Animal animal);
}

class CheckIfHopper implements CheckTrait{
    @Override
    public boolean test(Animal animal) {
        return animal.canHop();
    }
}