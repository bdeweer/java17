package certification.chapter5;

public class Part13 {
}

class Ostrich {

    public void fly(int i){
        System.out.println("int");
    }

    public void fly(long l){
        System.out.println("long");
    }

    public static void main(String[] args) {
        var p = new Ostrich();
        p.fly(123); //int
        System.out.println("-");
        p.fly(123L); //long
    }
}
