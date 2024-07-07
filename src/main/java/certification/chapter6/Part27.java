package certification.chapter6;

public class Part27 {
}

abstract class Mammal3 {

    abstract CharSequence chew();
    public Mammal3(){
        System.out.println(chew());
    }
}

class Platypus extends Mammal3 {
    String chew(){
        return "yummy!";
    }

    public static void main(String[] args) {
        new Platypus();
    }
}