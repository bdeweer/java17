package certification.chapter5;

public class Part14 {


}

class Kiwi {

    public void fly(int numMiles){
        System.out.println("primitive");
    }

    //Valid overloading
    public void fly(Integer numMiles){
        System.out.println("wrapper");
    }

    public static void main(String[] args) {

        Kiwi k = new Kiwi();
        k.fly(3); //prints primitive
        k.fly(Integer.valueOf(3)); //prints wrapper
    }
}