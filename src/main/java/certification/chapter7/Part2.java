package certification.chapter7;

public class Part2 {
}

abstract class Animal {
    abstract int getType();
}

interface Fly {
    void fly();
}

abstract class Bird extends Animal implements Fly{
    abstract boolean canSwoop();
}

interface Swim {
    void swim();
}

class Swan extends Bird implements Swim {

    @Override
    int getType() {
        return 0;
    }

    @Override
    boolean canSwoop() {
        return false;
    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}