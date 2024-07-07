package certification.chapter7;

import java.time.LocalDate;

public class Part34 {
}

record Crane9(int numberEggs, String name){
    //overloaded constructor
    public Crane9(String firstName, String lastName) {
        this(0, firstName + " " + lastName);
    }
}

record RabbitFood(int size, String brand, LocalDate expires){
    public static int MAX_STORAGE = 100;
    public RabbitFood(){
        this(10, "", null);
        //this.size = 10; does not compile
        //this.brand = ""; does not compile
        //this.expires = null; does not compile
    }
}