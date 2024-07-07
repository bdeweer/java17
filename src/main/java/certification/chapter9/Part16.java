package certification.chapter9;

import java.util.ArrayList;
import java.util.List;

public class Part16 {

    public static void main(String[] args) {

        Crate<Elephant> crateForElephant = new Crate<>();
        Elephant elephant = new Elephant();
        crateForElephant.packCrate(elephant);
        Elephant inNewHome = crateForElephant.lookInCrate();

        Crate<Zebra> crateForZebra = new Crate<>();
        Zebra zebra = new Zebra();
        crateForZebra.packCrate(zebra);
        Zebra zebraHome = crateForZebra.lookInCrate();

        Integer numPounds = 15_000;
        SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(elephant, numPounds);
    }
}

class Elephant {}

class Zebra {}

class Crate<T> {

    private T contents;
    public T lookInCrate(){
        return contents;
    }

    public void packCrate(T contents){
        this.contents = contents;
    }
}

class SizeLimitedCrate<T,U> {
    private T contents;
    private U sizeLimit;

    public SizeLimitedCrate(T contents, U sizeLimit) {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }
}

class LongTailAnimal {
    //protected void chew(List<Object> input){}
    protected void chew(List<Double> input){}// does not compile (type erasure)
}

class Anteater extends LongTailAnimal {
    protected void chew(List<Double> input){} //does not compile (type erasure)

    //protected void chew(List<Object> input){} //same generic type in the overridden method (ok)
    protected void chew(ArrayList<Double> input){} //overloaded
}