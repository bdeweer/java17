package certification.chapter6;

public class Part15 {
}

class Primate {
    public Primate(){
        System.out.println("Primate-");
    }
}

class Ape extends Primate {
    public Ape(int fur){
        System.out.println("Ape1-");
    }
    public Ape(){
        System.out.println("Ape2-");
    }
}

class Chimpanzee extends Ape{

    public Chimpanzee(){
        super(2);
        System.out.println("Chimpanzee-");
    }

    public static void main(String[] args) {
        new Chimpanzee();
    }
}