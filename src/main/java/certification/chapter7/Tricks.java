package certification.chapter7;

import java.time.LocalDate;

public class Tricks {

    private final String testOuter ="test";

    protected final class MyNestedClass {


        private MyNestedClass(){
            System.out.println(testOuter);
        }

        static private final String test = "test";

        public void localClassMethod(){

             class LocalClass {

            }
        }
    }

    public void testAnonymousClass(){

        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };

        MyNestedClass myNestedClass = new MyNestedClass();
        myNestedClass.localClassMethod();;
    }

    static class MyNestedStaticClass {

        public void testMyNestedMethod(){}
        public static void testMyNestedStaticMethod(){}
    }

    private static enum Season2 {
        WINTER, SPRING
    }

    private enum Season {
        WINTER, SPRING;

        private Season(){}
    }

    public static void main(String[] args) {

        MyNestedStaticClass myNestedStaticClass = new MyNestedStaticClass();
        myNestedStaticClass.testMyNestedMethod();
        myNestedStaticClass.testMyNestedStaticMethod();
        MyNestedStaticClass.testMyNestedStaticMethod();

        //MyNestedClass myNestedClass = new MyNestedClass();
        Season winter = Season.WINTER;
        Season2 winter2 = Season2.WINTER;

        Season.values();

        //System.out.println(winter == winter2);
        System.out.println(winter.equals(winter2));

        System.out.println(Season.SPRING.ordinal());

        Season sprin = Season.valueOf("SPRIN");
        System.out.println(sprin);

        String test = switch(winter){
            case WINTER -> {
                System.out.println("toto");
                yield "toto";
            }
            case SPRING -> {
                System.out.println("test");
                yield "toto";
            }
        };
    }
}


interface CanBurrow {
    public static final int MINIMUM_DEPTH = 2;

    abstract int count();

    enum Test {}

    class Toto {}

    private static void testPrivateStatic() {

    }
    private void testPrivate(){
        System.out.println(MINIMUM_DEPTH);
        testDefault();
        testStatic();
        count();
    }

    default void testDefault(){
        System.out.println(MINIMUM_DEPTH);
        count();
    }

    default void testDefault2(){
        testDefault();
        System.out.println(MINIMUM_DEPTH);
        testStatic();
    }

    static void testStatic(){
        System.out.println(MINIMUM_DEPTH);


    }

    interface Inner2 {}

    interface innerI extends CanBurrow, Inner2 {}
}



class Ghost {

    public static void boo(){
        System.out.println("Not scared");
    }

    protected final class Spirit {
        public void boo(){
            System.out.println("Booo!");
        }
    }

    public static void main(String[] args) {

        //var g = new Ghost().new Spirit() {}; //because of final
        new Ghost().boo();
        Ghost.boo();
    }
}

class Deer {
    enum Food {APPLe, BERRIES, GRASS}
    protected class Diet {
        private Food getFavorite(){
            return Food.BERRIES;
        }
    }

    public static void main(String[] args) {
        //System.out.println(switch (new Diet().getFavorite()){} //cannot be instantiated from a static context
    }
}

record RabbitFood2(int size, String brand, LocalDate expires){
    public static int MAX_STORAGE = 100;
    public RabbitFood2(){
        this(1, "", LocalDate.now());
    }

    public RabbitFood2{
        size = MAX_STORAGE;
        //this.size=10; //Does not compile
    }
}

class Lion {

    class Cub {}
    static class Den {}
    static void rest(){
        //Cub a = Lion.new Cub(); //invalid syntax
        //Lion.Cub b = new Lion().Cub(); //invalid syntax
        Lion.Cub c = new Lion().new Cub();
        var d = new Den();
        //var e = Lion.new Cub(); //invalid syntax
        //Lion.Den f = Lion.new Den(); //invalid syntax
        Lion.Den g = new Lion.Den();
        //var h = new Cub(); //Invalid syntax
    }
}

interface BigCat {
    abstract String getName();
    static int hunt(){
        //getName();
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
        //roar();
        return true;
    }

    private int rest(){
        return 2;
    }
}

enum Animals {
    MAMMAL(true), INV(Boolean.FALSE), FISH(false){
        public int swim(){
            return 4;
        }
    };

    final boolean hasHair;
    private Animals(boolean hasHair){
        this.hasHair = hasHair;
    }

    public boolean isHasHair(){
        return hasHair;
    }
    public int swim(){
        return 0;
    }
}


sealed class Bird4 {
    public final class Flamingo extends Bird4 {}
}

sealed class Monkey{}

final class Emperor4 extends Monkey{}
non-sealed class Mandrill extends Monkey{}

sealed class Friendly extends Mandrill permits Silly {}

final class Silly extends Friendly{}


class Zebra2 {
    private int x = 24;
    public int hunt(){
        String message = "x is";
        abstract class Stripes {
            private int x = 0;
            public void print(){
                System.out.println(message + Zebra2.this.x);
            }
        }
        var s = new Stripes(){};
        s.print();
        return x;
    }

    public static void main(String[] args) {
        new Zebra2().hunt();
    }
}

