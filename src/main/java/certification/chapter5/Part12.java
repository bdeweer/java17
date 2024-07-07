package certification.chapter5;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Part12 {


}

class Pelican  {

    public void fly(String s){
        System.out.println("string");
    }
    public void fly(Object o){
        System.out.println("object");
    }

    public static void main(String[] args) {
        var p = new Pelican();
        p.fly("test"); //string
        System.out.println("-");
        p.fly(56); //object (Java autoboxes to Integer)
    }
}

class Parrot {

    public static void print(List<Integer> i){
        System.out.println("I");
    }

    public static void print(CharSequence c){
        System.out.println("C");
    }

    public static void print(Object o){
        System.out.println("O");
    }

    public static void main(String[] args) {
        print("abc"); //C (String and StringBuilder implements CharSequence)
        print(Arrays.asList(3)); //I //Create a List<Integer>
        print(LocalDate.of(2029, Month.OCTOBER, 4)); //O
    }
}