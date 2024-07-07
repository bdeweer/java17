package tests.practice;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder("54321");

        builder.substring(2);

        System.out.println(builder.charAt(1));

    }
}


class Dinausaur {

    class Pterodactyl extends Dinausaur {

    }

    public void roar(){

        var dino = new Dinausaur();
        dino.new Pterodactyl();

        Pterodactyl pterodactyl = new Pterodactyl();

        new Dinausaur.Pterodactyl();
    }
}

class Laptop extends Computer {
    public void startup(){
        System.out.println("Laptop");
    }
}
class Computer {
    public void startup(){
        System.out.println("Computer");
    }

    public static void main(String[] args) {
        Computer computer = new Laptop();
        Laptop laptop = new Laptop();
        computer.startup();
        laptop.startup();
    }
}

class Cars {
    private static void drive(){
        {
            System.out.println("Zoom");
        }
        System.out.println("Fast");
    }
    static {
        System.out.println("faster");
    }

    public static void main(String[] args) {
        drive();
        drive();
    }
}

class Animal {

    public String race;
    private int age;
}

class Dog extends Animal {

    private String name;

    public void test(){

        System.out.println(this.name);

        System.out.println(this.race);
        System.out.println(super.race);


    }
}




sealed class Organ {

    sealed class Heart extends Organ{}

    static non-sealed class Stomach extends Organ {}
    final class Lung extends Organ {}

    final class Valentine extends Heart {}
}

final class Blood extends Organ.Stomach {}



class Jump {
    private int rope = 1;
    protected boolean outside;

    public Jump(){

        this(4);
        outside = true;
    }

    public Jump(int rope){
        this.rope = outside ? rope : rope+1;
    }

    public static void main(String[] args) {
        System.out.println(new Jump().rope);
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
            final int distance = 3;
            @Override
            public void swim(int distance) {
                System.out.println(distance);
            }
        };
        seaTurtle.swim(7);
    }
}

interface Building {
    default Double getHeight(){
        return 1.0;
    }

    static interface Test{}

    static class Test2{}
}

interface Office {
    public default String getHeight(){
        return null;
    }
}

record Disco(int beats){
    public Disco(String beats){
        this(20);
        System.out.println("la");
    }
    public Disco {
        beats = 10;
        System.out.println("ici");
    }

    public int getBeats(){
        return beats;
    }

    public static void main(String[] args) {
        System.out.println(new Disco(20).beats());;
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

class Matrix {
    private int level = 1;
    class Deep {
        private int level = 2;
        class Deeper {
            private int level = 5;

            public void printReality(int level){
                System.out.println(this.level+"");
                System.out.println(Matrix.Deep.this.level);
                System.out.println(Deep.this.level);
            }
        }
    }

    public static void main(String[] args) {
        Matrix.Deep.Deeper sim = new Matrix().new Deep().new Deeper();
        sim.printReality(6);

    }
}


class Penguin {
    private int volume = 1;
    private class Chick {
        private static int volume = 3;
        void chick(int volume){
            System.out.println("Honk("+Penguin.this.volume+"!");
        }
    }

    public static void main(String[] args) {
        Penguin p = new Penguin();
        final Penguin.Chick little = p.new Chick();
        little.chick(4);
    }
}

class Earth {
    private abstract class Sky {
        void fall(){
            new Sky(){};
        }
    }
}

class Racecar {
    final private int speed = 88;
    final protected class Engine {
        private final int speed = 100;
        public final int getSpeed(){

            return Racecar.this.speed;
        }
    }

    final Engine e = new Engine();

    public static void main(String[] args) {
        System.out.println(new Racecar().e.getSpeed());
    }
}

abstract class School {
    abstract Float getNumTeachers();
    public int getNumStudents() throws IOException {
        return 10;
    }
}

class Highschool extends School {
    final Float getNumTeachers(){
        return 4f;
    }
    public int getNumStudents() throws FileNotFoundException {
        return 3;
    }

    public static void main(String[] args) throws Exception{
        var school = new Highschool();
        school.getNumStudents();
    }
}

record User(LocalDate creationDate){
    static LocalDate today = LocalDate.now();
    public User {
        creationDate = today;
        creationDate = today;
    }

    public static void main(String[] args) {
        LocalDate yesterday = LocalDate.now().minus(1, ChronoUnit.DAYS);
        var u = new User(yesterday);
        System.out.println(u.creationDate);
    }
}

class Complex {
    class Building {}

    final class House extends Building{}

    public void convert(){
        Building b1 = new Building();
        House h1 = new House();

        Building b2 = new House(); //you don't need a cast operator if casting to an inherited super type
        House trapHouse = (House)b1; //if you want to access a subtype of the current reference, you need to perform an explicit cast with a compatible type. - Casting a reference from a super type to a subtype requires an explicit cast

        Building b3 = h1; //casting a reference from a subtype to a super type doesn't require an explicit cast

        Building b4 = (House)b1; //provoquera un ClassCastException si b1 n'est pas une instance de house

        //House h2 = (Building)h1;
        Building b5 = (Building)b2;
        House h3 = (House)b2;

       // Building b3 = (House)b1;
       // House h2 = (Building)h1;

        //Building b4 =(Building) b2;
        //House h3 = (House)b2;

    }

    public static void main(String[] args) {
        new Complex().convert();
    }
}

interface Tool {
    void use(int fun);
}

abstract class Childcare {
    abstract void use(int fun);
}

final class Stroller extends Childcare implements Tool {
    final public void use(int fun){
        final int width = 5;
        class ParkVisit {
            final int getValue(){
                return width + fun;
            }
        }
        System.out.println(new ParkVisit().getValue());
    }
}

class Ready {
    protected static int first = 2;
    private static final short DEFAULT_VALUE = 10;
    private static class GetSet {
        int first = 5;
        static int second = DEFAULT_VALUE;
    }

    private GetSet go = new GetSet();

    public static void main(String[] args) {

        Ready r = new Ready();
        System.out.println(r.go.first);
        System.out.println(","+r.go.second);
    }
}

abstract class Ball {
    protected final int size;
    public Ball(int size){
        this.size = size;
    }
}

interface Equipment {}

class SoccerBall extends Ball implements Equipment {

    public SoccerBall(){
        super(3);
    }

    public Ball get(){
        return this;
    }

    public static void main(String[] args) {
        var equipment = (Equipment)(Ball)new SoccerBall().get();
        int i = ((SoccerBall)equipment).size;
    }
}

class Bunny {
    static interface Rabbit {}
    static class FlemishRabbit implements Rabbit {}

    private static void hop(Rabbit r){
        System.out.println("hop");
    }
    private static void hop(FlemishRabbit f){
        System.out.println("HOP");
    }

    public static void main(String[] args) {
        Rabbit r1 = new FlemishRabbit();
        FlemishRabbit r2 = new FlemishRabbit();

        hop(r1);
        hop(r2);
    }
}

class MissCallException extends Exception {}
class Phone {
    static void makeCall() throws RuntimeException {
        throw new ArrayIndexOutOfBoundsException("Call");
    }

    public static void main(String[] args) {
       /* try{

        }catch(MissCallException e){
            throw new RuntimeException("Voicemail");
        }*/
    }
}

class Chapter5{



    public static void main(String[] args) {

        Optional<String> opt = Optional.of("Cup");

        System.out.println(opt.orElseThrow());

    }

}


