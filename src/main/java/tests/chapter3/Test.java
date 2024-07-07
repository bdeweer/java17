package tests.chapter3;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

public class Test {

    int Integer = 3;

    public static void main(String[] args) {

        int String = 1;

        Bunny myBunny = new CuteBunny();
        Object b = new Bunny();
        CuteBunny cuteBunny = (CuteBunny) new Bunny();

    }
}

enum Color {
    BROWN, YELLOW, BLACK;
    public String name;
    public static Color DEFAULT = BROWN;
}

enum Shape {
    SQUARE, REACTANGLE;
    public static Color color;
}

record Pony(String name) {
    static int age;
    static {
        age = 10;
    }
}

class Phone {

    private int size;

    public Phone(int size){
        size = this.size;
    }
    public static void sendHome(Phone p, int newSize, int i){
        p = new Phone(newSize);
        p.size = 4;
        i = 6;
    }

    public static void main(String[] args) {
        final var phone = new Phone(3);
        int i = 10;
        sendHome(phone, 7, i);
        System.out.println(phone.size + " " + i);
    }
}

class Dinosaur {

    Closeable c;
    class Pterodactyl extends Dinosaur {}
    public void roar(){
        var dino = new Dinosaur();
        new Dinosaur.Pterodactyl();

        dino.new Pterodactyl();
    }
}
record Animal(boolean isMammal){}

record Panda(String name) {
    public Panda(){
        this("Taishan");
        System.out.println(name);
    }
    public Panda {
        name = name.toLowerCase();
    }

    public static void main(String[] args) {
        new Panda().name();
    }
}

interface Pump {
    public abstract String toString();
}

@FunctionalInterface
interface Bend extends Pump{
    void bend(double tensileStrenght);
}

class Robot {
    public final void apply(
            Bend instruction, double input
    ){
        instruction.bend(input);
    }

    public static void main(String[] args) {
        final Robot r = new Robot();
       // Consumer<Double> instruction = (x -> System.out.println(x + " bent!"));
      //  instruction.accept(5.0d);
        //r.apply(instruction, 5);
        r.apply(x -> System.out.println(x + " bent!"), 5);
    }
}

class Plant {
    String type = "plant";

    public String getType(){
        return type;
    }

    public static void main(String[] args) {
        Plant w1 = new Bush();
        Bush w2 = new Bush();
        Plant w3 = w2;
        System.out.println(w1.type + " " + w2.type + " " + w3.type);
        System.out.println(w1.getType() + " " + w2.getType() + " " + w3.getType());
    }
}

class Bush extends Plant {
    String type = "bush";

    public String getType(){
        return type;
    }
}

interface Toy {
    String play();
}

class Gift {
    public static void main(String[] args) {
        abstract class Robot {}
        class Transformer extends Robot implements Toy {
            public String name = "GiantRobot";
            public String play(){
                return "DinosaurRobot";
            }
        }

        Transformer prime = new Transformer(){
            public String play(){
                return name;
            }
        };

        System.out.println( prime.play() + " ");
    }
}


class Bottle {
    public static class Ship {
        private enum Sail {

            TAIL {
                protected int getHeight(){
                    return 100;
                }
            },
            SHORT {
                protected int getHeight(){
                    return 2;
                }
            };
            protected abstract int getHeight();

            public Sail getSail(){
                return Sail.TAIL;
            }
        }

        public static void main(String[] args) {
            var bottle = new Bottle();
            //Ship q = bottle.new Ship(); //must implemented in a static manner!!!
        }

        public void test(){
            new Ship();
        }

        public static void test2(){
            new Ship();
        }
    }
}

abstract interface CanSwim {
    public void swim(final int distance);
}

class Turtle {
    final int distance = 2;

    public static void main(String[] args) {
        final int distance = 3;
        CanSwim seaTurtle = new CanSwim() {
            @Override
            public void swim(int distance) {
                System.out.println(distance);
            }
        }; //très important ce ;
        seaTurtle.swim(7);
    }
}

class Puppy {
    public static int wag = 5;
    public void Puppy(int wag){
        this.wag = wag;
    }
}

interface Building {
    default Double getHeight(){
        return 1.0;
    }
}
interface Office {
    default String getHeight(){
        return null;
    }
}

class Car {
    void drive()throws Exception {}
}

class SportCar extends Car {
    @Override
    public void drive()throws IllegalArgumentException, IOException{}
}

record Disco(int beats){
    public Disco(String beats){
        this(20);
    }
    public Disco{
        beats = 10;
    }
    public int getBeats(){
        return beats;
    }

    public static void main(String[] args) {
        System.out.println(new Disco(30).beats());
    }
}

interface Speak {
    public default int getVolume(){
        return 20;
    }
}

interface Whisper {
    public default int getVolume(){
        return 10;
    }
}

class Debate implements Speak, Whisper {
    public int getVolume(){
      //  Whisper.super.getVolume();
        return 30;
    }

    public static void main(String[] args) {
        var d = new Debate();
        //Whisper.super.getVolume(); //cannot be called from a static context
        System.out.println(d.getVolume());
    }
}

class Bunny {
    public int carrots = 12;
    public void eatDinner(){}
}

class CuteBunny extends Bunny{}

class Matrix {
    private int level = 1;
    class Deep {
        private int level = 2;
        class Deeper {
            private int level = 5;
            public void printReality(int level){
                System.out.println(this.level + " ");
                System.out.println(Matrix.Deep.this.level + "");
                System.out.println(Deep.this.level);
            }
        }
    }

    public static void main(String[] args) {
        Matrix.Deep.Deeper simulation = new Matrix().new Deep().new Deeper();
        simulation.printReality(6);
    }
}

sealed interface Time permits Hour, Minute, Second {}

record Hour() implements Time {}
sealed interface Minute extends Time {}

final class Min implements Minute{}
non-sealed class Second implements Time{}

class Micro extends Second{}

interface MusicCreator {
    public Number play();
}

abstract class StringInstrument {
    public abstract Long play();
}

class Violin extends StringInstrument implements MusicCreator {
    @Override
    public Long play() {
        return null;
    }
}

class Ski {
    private int age = 18;

    private static void slalom(Ski racer, String name){
        //racer = new Ski();
        racer.age = 18;
        name = "Wendy"; //no effect
        racer = null; //no effect
    }

    public static void main(String[] args) {

        final var mySkier = new Ski();
        mySkier.age=16;
        final String myName = "Rosie";
        slalom(mySkier, myName);

        System.out.println(mySkier.age + " " + myName);
    }
}

class Penguin {
    private int volume = 1;
    private class Chick {
        private static int volume = 3;
        void chick(int volume){
            System.out.println("Honk("+Penguin.this.volume+")!");
        }
    }

    public static void main(String[] args) {
        Penguin penguin = new Penguin();
        final Penguin.Chick little = penguin.new Chick();
        little.chick(5);
    }
}

class RaceCar {
    final private int speed = 88;
    final protected class Engine {
        private final int speed = 100;
        public final int getSpeed(){
            return RaceCar.this.speed;
        }
    }
    final Engine engine = new Engine();
    final public static void main(String ... args){
        System.out.println(new RaceCar().engine.getSpeed());
    }
}

interface Tasty {
    default void eat(){
        System.out.println("Spoiled!");
    }
}

class ApplePicking {
    public static void main(String[] args) {
        var appled = new Tasty(){
            @Override
            public void eat(){
                System.out.println("Yummy");
            }
        };
    }
}