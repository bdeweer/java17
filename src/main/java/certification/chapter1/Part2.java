package certification.chapter1;

public class Part2 {

    public static float tricky;

    public static void main(String[] args) {

        //long max = 3123456787; //out of range
        long max = 3123456787L; //or l

        //int octal = 019; //does not compile
        int octal = 017; //15 in decimal
        int hexa = 0x15;

        int binary = 0B0; //or 0b
        //int binary = 0B2; //does not compile

        int million1 = 1000000;
        int million2 = 1_000_000;

        //float temp = 50.9; //does not compile


        //int underscore = _1000; //does not compile
        //int underscore = 1000_; //does not compile
        //double underscore = 1000_.0; //does not compile
        //double underscore = 1000._0; //does not compile

        double annoyingButLegal = 1_00_0.0_0;
        double strange = 1____________0;


        System.out.println(tricky); //0.0 - not 0.0f!!! (f is never printed)

        //int 1908_s; // does not compile

        int Amount = 0b11;
        //int amount = 9L;
        double amount = 9_2.1_2;


    }
}
