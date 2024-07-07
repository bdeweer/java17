package certification.tricks;

import java.time.LocalDate;

public class Tricks {

    public static void main(String[] args) {


    }

}

class Lion {

    class Cub {}

    static class Den {}

    static void rest(){

        //Cub a = Lion.new Cub();
        //Lion.Cub b = new Lion().Cub();
        Lion.Cub a = new Lion().new Cub();
        var d = new Den();
        //var e = Lion.new Cub();

        //Lion.Den f = Lion.new Den();
        Lion.Den g = new Lion.Den();
        //var h = new Cub();
    }
}

interface Swim {
    default void perform(){
        System.out.println("Swim!");
    }
}

interface Dance {
    default void perform(){
        System.out.println("Dance!");
    }
}

class Penguin implements Swim, Dance {

    @Override
    public void perform() {

        System.out.println("Smile!");
    }

    private void doShow(){
        Swim.super.perform();
    }

    public static void main(String[] args) {
        new Penguin().doShow();
    }
}


interface BigCat {

    abstract String getName();

    static int hunt(){
        //getName(); does not compile
        return 5;
    }

    default void climb(){
        rest();
    }

    private void roar(){
        getName();
        climb();
        hunt();
    }

    private static boolean sneak(){
        //roar(); does not compile
        return  true;
    }

    private int rest(){
        return 2;
    }
}

class Zebra {
    private int x = 24;

    public int hunt(){
        String message = "x is";
        abstract class Stripes {
            private int x = 0;
            public void print(){
                System.out.println(message + Zebra.this.x);
            }
        }

        var s = new Stripes(){};
        s.print();
        return x;
    }

    public static void main(String[] args) {
        new Zebra().hunt();
    }
}


abstract class Elephant {
    abstract private class SleepsALot {
        abstract int sleep();
    }
}

sealed class Bird6 {

    public final class Flamingo extends Bird6 {}

}

sealed class Monkey {}

//class EmperorTamarin extends Monkey {}

non-sealed class Mandrill extends Monkey{}

//sealed class Friendly extends Mandrill permits Silly {} does not compile because Silly must extends Friendly

final class Silly {}