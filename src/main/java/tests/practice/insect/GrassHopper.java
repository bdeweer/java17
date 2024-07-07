package tests.practice.insect;

import tests.practice.animals.Hopper;

public class GrassHopper extends Hopper {

    public void move(){
        hop();
    }

    public static void main(String[] args) {

        var hopper = new GrassHopper();
        hopper.move();
        hopper.hop(); //we are in a subclass
    }
}

class Butterfly {
    public static void main(String[] args) {

        var hopper = new GrassHopper();
        hopper.move();
        //hopper.hop(); //we aren't in a subclass
    }
}