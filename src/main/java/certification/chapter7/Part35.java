package certification.chapter7;

public class Part35 {
}

record Crane10(int numberEggs, String name){

    public Crane10(int numberEggs, String firstName, String lastName){
        this(numberEggs + 1, firstName + "  " + lastName);
        numberEggs = 10; //too late and no effect
        //this.numberEggs = 20; does not compile
    }
}
