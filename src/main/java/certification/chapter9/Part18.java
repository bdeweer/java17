package certification.chapter9;

public class Part18 {
}

record Robot(){}

interface Shippable<T> {
    void ship(T t);
}

//specific
class ShippableRobotCrate implements Shippable<Robot> {
    public void ship(Robot r){}
}

//generic
class ShippableAbstractCrate<U> implements Shippable<U>{

    @Override
    public void ship(U u) {

    }
}

//old way
class ShippableCrate implements Shippable {

    @Override
    public void ship(Object o) {

    }
}

