package tests.chapter2;

import java.util.Collection;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        int m=0, n=0;
        while(m<5){
            n++;
            if(m==3)continue;

            switch(m){
                case 0:
                case 1:
                    n++;
                default:
                    n++;
            }
            m++;
        }

        System.out.println(m + " " + n);
    }

    public static void zero(Object number){
        if(number instanceof Integer n && Math.abs(n) == 0)
            System.out.println("zero");
    }
}

class Penguins {
    public static void main(String[] args) {
        var pen = new Penguins();
        pen.length("penguins");
        pen.length(5);
        pen.length(new Object());
    }
    public void length(Object obj){
        if(obj instanceof String x){
            System.out.println(x.length());
        }
    }
}

enum Admission {ADULT, SENIOR, CHILD}
class Movie {
    public static void main(String[] args) {
        var price = switch(Admission.CHILD){
            case ADULT -> 12.50;
            case SENIOR, CHILD -> 10;
        };
        System.out.println(price);
    }
}

class Park {

    public static void main(String[] args) {

        int i = 5;
        switch(i){
            case 1 -> {
                System.out.println("test");
                break;
                }

            }
        }
}

