package certification.chapter6;

public class Part7 {
}

class Hamster {
    private String color;
    private int weight;

    public Hamster(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Hamster(int weight) {
        this("brown", weight); //must be the first statement of the constructor, only one call to this() in any constructor
        //this.weight = weight;
        //color = "brown";
    }
}


class Gopher {

    public Gopher(){this(4); }

    public Gopher(int dugHoles){
        //this(); //cyclic calls, if uncomment both constructor don't compile
    }
}