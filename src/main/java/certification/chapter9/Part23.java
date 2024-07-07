package certification.chapter9;

import java.util.List;

public class Part23 {

    public static void main(String[] args) {


    }

    private void anyFlyer(List<Flyer> flyer){} //Can be call with a mix of types
    private void groupOfFlyers(List<? extends Flyer> flyers){} //Can be call only with the same type
}

interface Flyer { void fly(); }

class HangGlider implements Flyer {
    public void fly() {}

}

class Goose implements Flyer {
    public void fly(){}
}