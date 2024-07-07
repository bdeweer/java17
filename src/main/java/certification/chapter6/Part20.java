package certification.chapter6;

public class Part20 {
}

class Bear {
    public static void eat(){
        System.out.println("Bear is eating");
    }
}

class Panda extends Bear {
    //method hiding
    public static void eat(){
        System.out.println("Panda is chewing");
    }

    public static void main(String[] args) {

        eat(); //Panda is chewing
    }
}