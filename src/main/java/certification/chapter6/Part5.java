package certification.chapter6;

public class Part5 {
}


class Reptile {
    protected int speed = 10;
}

class Crocodile extends Reptile {
    protected int speed = 20; // declaring a variable with the same name as an inherited variable is referred to as hiding variable

    public int getSpeed(){
        //return speed; //return 20
        return super.speed; //return 10
    }

    public static void main(String[] args) {
        var croc = new Crocodile();
        System.out.println(croc.getSpeed());
    }
}


class Insect {
    protected int numberOfLegs = 4;
    String label = "buggy";
}

class Beetle extends Insect {
    protected int numberOfLegs = 6;
    short age = 3;
    public void printData(){
        System.out.println(this.label); //buggy
        System.out.println(super.label); //buggy
        System.out.println(this.age); //3
        //System.out.println(super.age); does not compile
        System.out.println(numberOfLegs); //6
    }

    public static void main(String[] args) {
        new Beetle().printData();
    }
}