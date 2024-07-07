package certification.chapter6;

public class Part13 {
}

class MouseHouse2 {

    private final int volume;
    private final String name;

    public MouseHouse2(){
        this.name = "Empty House"; //Constructor assignment
    }
    {
        volume = 10; //Instance initializer assignment
    }
}


class MouseHouse3 {
    private final int volume;
    private final String type;
    {
        this.volume = 10;
    }
    public MouseHouse3(String type){

        this.type = type;
    }

    public MouseHouse3(){
        this(null);
        //this.volume = 2; //does not compile
    }
}