package certification.chapter6;

public class Part10 {
}

class Mammal{
    public Mammal(int age){}
}

class Seal extends Mammal{
    public Seal(){
        super(6); //mandatory call
    }
}

class Elephant extends Mammal {
    public Elephant(){
        super(5); //mandatory call
    }
}