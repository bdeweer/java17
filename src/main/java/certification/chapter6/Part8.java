package certification.chapter6;

public class Part8 {
}

class Animal2 {

    private int age;

    public Animal2(int age){
        super();
        this.age = age;
    }
}

class Zebra extends Animal2 {
    public Zebra(int age){
        super(age);
    }
    public Zebra(){
        this(4); //Refers to constructor in Zebra with int argument
    }
}