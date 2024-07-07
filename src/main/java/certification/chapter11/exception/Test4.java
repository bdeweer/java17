package certification.chapter11.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test4 {

    public static void main(String[] args) {

        int grade = (Integer) null; //NPE

        Integer lumiere = null;
        if(lumiere > 0){ //NPE
            System.out.println("Light is on");
        }
    }
}

class WhaleSharkException extends Exception {
    public WhaleSharkException(){
        super("Friendly shark!");
    }
    public WhaleSharkException(String message){
        super(new Exception(new WhaleSharkException()));
    }
    public WhaleSharkException(Exception e){}
}

class Football {
    public static void main(String[] args) {
        try {
            System.out.println("W");
            throw new ArrayIndexOutOfBoundsException();
        }catch(RuntimeException r){
            System.out.println("X");
            try {
                throw r;
            }catch(Exception e){
                System.out.println("Y");
            }
        }catch(Exception e){
            System.out.println("Y2");
        } finally {
            System.out.println("Z");
        }
    }
}

class Light {
    public static void main(String[] args) throws Exception{
        try {
            new Light().turnOn();
        }catch(RuntimeException v){
            System.out.println(v);
            throw new IOException();
        }
        finally {
            System.out.println("complete");
        }
    }

    public void turnOn() throws IOException {
        new IOException("Not ready");
    }
}

class SpellingException extends RuntimeException {}

class SpellChecker {
    public static void main(String[] args) {

        try {
            if(!"cat".equals("kat")){
                new SpellingException();
            }
        }catch(SpellingException | NullPointerException e ){
            System.out.println("Spelling problem!");
        }catch(Exception e){
            System.out.println("Unknown problem");
        }
        finally {
            System.out.println("Done!");
        }
    }
}

class Beach {
    class TideException extends Exception {}
    public void surf() throws RuntimeException {
        try {
            throw new TideException();
        }catch(Exception e){

        }
    }
}

class Fetch {
    public int play(String name) throws RuntimeException{
        try {
            throw new RuntimeException(name);
        }catch(Throwable e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws RuntimeException{
        new Fetch().play("Webby");
        new Fetch().play("Jiro");
    }
}

class Computer {
    public void compute() throws Exception {
        throw new NullPointerException("Does not compute!");
    }

    public static void main(String[] args) throws Exception{
        try {
            new Computer().compute();
        }catch(RuntimeException e){
            System.out.println("zero");
            throw e;
        }catch(Exception e){
            System.out.println("one");
            throw e;
        }
    }
}

class Chair {
    public void sit() throws IllegalArgumentException {
        System.out.println("creak");
        throw new RuntimeException();
    }
}

class Stool extends Chair {
    public void sit() throws RuntimeException {
        System.out.println("thud");
    }

    public static void main(String[] args) throws Exception {
        try {
            new Stool().sit();
        }finally {
            System.out.println("?");
        }
    }
}

class Pizza {
    Exception order(RuntimeException e){
        throw e;
    }

    public static void main(String[] args) {
        var p = new Pizza();
        try {
            p.order(new IllegalArgumentException());
        }catch(RuntimeException e){
            System.out.println(e);
        }
    }
}

class OfficeException extends RuntimeException {
    public OfficeException(Exception e){
        super(e);
    }

    public static void main(String[] args) throws Exception{
        try {
            throw new OfficeException(new IOException());
        }catch(RuntimeException e){
            System.out.println(e.getCause());
        }
    }
}

class FallenException extends Exception {}
final class HikingGear implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new FallenException();
    }
}

class Cliff {
    public final void climb() throws Exception {
        try(HikingGear gear = new HikingGear()){
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        try {
            new Cliff().climb();
        }catch (Throwable t){
            System.out.println(t);
        }
    }
}

class SnowStorm {
    static class WalkToSchool implements AutoCloseable {
        public void close(){
            throw new RuntimeException("flurry");
        }
    }

    public static void main(String[] args) {

        WalkToSchool walk1 = new WalkToSchool();
    }
}