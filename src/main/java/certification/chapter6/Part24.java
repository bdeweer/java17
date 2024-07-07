package certification.chapter6;

public class Part24 {
}

abstract class Canine {
    abstract public String getSound();
    public void bark(){
        System.out.println(getSound());
    }

    public static void main(String[] args) {
        Canine w = new Fox();
        w.bark();
    }
}

class Wolf extends Canine {
    @Override
    public String getSound() {
        return "Woooooof!";
    }
}
class Fox extends Canine{
    @Override
    public String getSound() {
        return "Squeak!";
    }
}
class Coyote extends Canine {
    @Override
    public String getSound() {
        return "Roar!";
    }
}