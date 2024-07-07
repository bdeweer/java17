package certification.chapter7;

public class Part32 {
}

record Crane6(int numberEggs, String name){
    //long constructor
    public Crane6(int numberEggs, String name){
        if(numberEggs < 0) throw new IllegalArgumentException();
        //all the fields must be set
        this.numberEggs = numberEggs;
        this.name = name;
    }

    //compact constructor

}


/*
does not compile (the constructor must set every fields)
record Crane7(int numberEggs, String name){
    public Crane7(int numberEggs, String name){}
}*/
