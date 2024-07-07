package certification.chapter7;

public class Part36 {
}

record Crane11(int numberEggs, String name){

    //You can't declare two record constructors that call each other infinitely or as a cycle

    /*public Crane11(String name){
        this(1);
    }

    public Crane11(int numberEggs){
        this("");
    }*/
}