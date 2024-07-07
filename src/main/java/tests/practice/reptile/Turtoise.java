package tests.practice.reptile;

import tests.practice.mammal.Hare;

public class Turtoise extends Hare {

    protected void race(Hare hare){


        hare.init();
       // hare.
    }

    public static void main(String[] args) {
        var turtoise = new Turtoise();
        turtoise.race();


        var hare = new Hare();
        turtoise.race(hare);
    }
}
