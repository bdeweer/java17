package certification.chapter3;

public class Part6 {

    public static void main(String[] args) {

        //1) Infinite loop
        //for(;;)
        System.out.println("Hello World");

        //2) Adding multiple terms to the for statement
        {
            int x=0;
            for(long y =0, z=4; x<5 && y<10; x++, y++){
                System.out.println(y + " ");
            }
            System.out.println(x + " ");
        }


        //3) Redeclaring a variable in the initialization block
        {
            int x =0;
            for (x = 4; x < 5; x++) { //int x = 4 does not compile
                System.out.println(x + "");
            }
        }

        //4) Using incompatible data types in the initialization block
        {
            int x = 0;
            for (long y = 0,  z = 4; x < 5; x++) { //int z =4 does not compile (
            System.out.println(y + " ");
            }
        }

        //5) Using loop variables outside the loop
        for(long y = 0, x = 4; x<5 && y < 10; x++, y++){
            System.out.println(y + " ");
        }
        //System.out.println(x); //does not compile
    }
}
