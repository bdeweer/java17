package certification.chapter7;

public class Part45 {
}

interface Canine {} //extends Dog to make not to have ClassCastException at runtime

interface Dog {}

//If the class is marked final, it will be impossible to cast (the compiler recognizes that there are no possible subclass of Wolf3 capable
class Wolf3 implements Canine {}

class Wolf4 extends Wolf3 implements Dog {}

class BadCasts {
    public static void main(String[] args) {

        Wolf3 wolfy = new Wolf3();
        //Wolf3 wolfy = new Wolf4();
        Dog badWolf = (Dog) wolfy; //compiles, ClassCasException at runtime
    }
}