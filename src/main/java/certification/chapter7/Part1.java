package certification.chapter7;

import java.awt.*;
import java.util.ArrayList;

public class Part1 implements Nocturnal, CanFly, Climb, HasBigEyes{

    public static void main(String[] args) {

        Part1 part1 = new Part1();
        part1.getSpeed(1);

    }

    @Override
    public Float getSpeed(int age) {
        return null;
    }

    @Override
    public void flap() {

        System.out.println("Flap!");
    }

    @Override
    public int hun() {
        return 5;
    }
}

abstract class Part1Bis implements HasBigEyes {} //n'a pas besoin d'impl

interface HasBigEyes extends Nocturnal, CanFly {

}

interface Nocturnal {
    public int hun();

}

interface CanFly {
    Number getSpeed(int age);
    void flap();

}

interface Climb {
    Number getSpeed(int age);
}




interface Walk2 {
    private static List move(){
        return null;
    }
}


interface Run2 extends Walk2 {
    public ArrayList move();
}

class Panther implements Run2 {

    @Override
    public ArrayList move() {
    //public List move() { !!list is more restrictive!!
        return null;
    }
}
