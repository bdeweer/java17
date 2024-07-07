package certification.chapter5;

public class Part3 {

    public static void main(String[] args) {

        test(); //valid call to var args
        test(1,2,3);
        test(null); //NullPointerException
    }

    public static void test(int ... tests){

        System.out.println(tests.length);
    }
}
