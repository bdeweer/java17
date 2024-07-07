package certification.chapter4;

public class Part11 {

    public static void main(String[] args) {

        //min / max
        System.out.println(Math.max(3,7)); //7
        System.out.println(Math.min(7,-9)); //-9

        //round
        long low = Math.round(123.45); //123
        System.out.println(low);
        long high = Math.round(123.50); // 124
        System.out.println(high);
        int fromFloat = Math.round(123.45f); //123
        System.out.println(fromFloat);

        //ceiling and floor
        double c = Math.ceil(3.14); //4.0
        double f = Math.floor(3.14); //3.0

        //exponents
        double squared = Math.pow(5,2); //25.0

        //random numbers
        double num = Math.random();
        System.out.println(num);

    }
}