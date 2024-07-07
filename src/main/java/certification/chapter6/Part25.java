package certification.chapter6;

public class Part25 {
}

abstract class Mammal2 {
    abstract void showHorn();
    abstract void eatLeaf();
}

abstract class Rhino extends Mammal2 {
    @Override
    void showHorn(){}
}
class BlackRhino extends Rhino{

    @Override
    void eatLeaf() {

    }
}
