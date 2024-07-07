package certification.chapter6;

public class Part9 {
}

class Animal3 {
    private int age;
    private String name;

    public Animal3(int age, String name){
        super();
        this.age = age;
        this.name = name;
    }

    public Animal3(int age){
        super();
        this.age = age;
        this.name = null;
    }
}

class Gorilla extends Animal3 { //class Gorilla must provide a call to any parent class constructor since there are not no args constructor defined

    public Gorilla(int age){
        super(age, "Gorilla");
    }
    public Gorilla(){
        super(5);
    }
}
