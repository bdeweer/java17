package certification.chapter1;

public class Part1 {
    String first = "first";
    String last = "last";

    String full = first + last;

    public static void main(String[] args) {

        /*

        comment




         */
    }
}

class Chick {
    private String name = "Fluffy";
    {
        System.out.println("setting field");
    }

    public Chick(){
        name = "Tiny";
        System.out.println("setting constructor");
    }

    public static void main(String[] args) {
        Chick chick = new Chick();
        System.out.println(chick.name);
    }
}

class Egg {
    public Egg(){

        number = 5;
    }

    public static void main(String[] args) {
        Egg egg = new Egg();
        System.out.println(egg.number); //5
    }
    {number = 4;}
    private int number = 3;

}