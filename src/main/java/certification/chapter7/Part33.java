package certification.chapter7;

public class Part33 {
}

record Crane7(int numberEggs, String name) {

    public Crane7 {
        if(numberEggs<=0) throw new IllegalArgumentException();
        //this.name = name.toUpperCase(); //does not compile
        name = name.toUpperCase();
    }
}

record Crane8(int numberEggs, String name){
    public Crane8 {
        //this.numberEggs = 5; does not compile
        numberEggs = 5;
    }
}