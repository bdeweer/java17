package certification.chapter5;

public class Part10 {
}

class Chimpanzee {

    public void run(Long t){}
    public void climb(long t){}
    public void swing(Integer u){}
    public void jump(int v){}

    public static void main(String[] args) {
        var c = new Chimpanzee();
        //c.run(123); //does not compile (cast then autoboxing KO)
        //c.run(Integer.valueOf(123)); //does not compile
        c.climb(123); //int value can be cast to long
        c.swing(123); //int value is autoboxed to Integer
        //c.jump(123L); //does not compile (long must be explicitly cast to an int)
    }
}
