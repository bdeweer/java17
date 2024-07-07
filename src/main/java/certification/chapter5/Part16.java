package certification.chapter5;

public class Part16 {
}

class Toucan {

    public void fly(int ... length){}
    //public void fly(int [] lengths){} //does not compile

    public static void main(String[] args) {
        Toucan t = new Toucan();
        t.fly(1,2,3);

        int [] ints = {1,2,3};
        t.fly(ints);
        t.fly();
    }
}