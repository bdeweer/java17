package certification.chapter2;

public class Part1 {

    public static void main(String[] args) {


        {
            int cookies = 4;
            double reward = 3 + 2 * --cookies;
            System.out.println("Zoo animals receives: " + reward + " rewards points"); //9.0
        }

        System.out.println("--------------------------------------------------------------------");

        //bitwise
        {
            int value = 3;
            int complement = ~value;
            System.out.println(value); //3
            System.out.println(complement); //-4

            System.out.println(-1*value-1); //-4
            System.out.println(-1*complement-1); //3
        }

        System.out.println("--------------------------------------------------------------------");

        //negation operator
        {
            double zooTemperature = 1.21;
            System.out.println(zooTemperature); //1.21
            zooTemperature = -zooTemperature;
            System.out.println(zooTemperature); //-1.21
            zooTemperature = -(-zooTemperature);
            System.out.println(zooTemperature); //-1.21
        }

        {
            //int pelican = !5;
            //boolean penguin = -true;
            //boolean peacock = !0;
        }

        System.out.println("--------------------------------------------------------------");

        //Increment and decrement operators
        {

            int parkAttendance=0;
            System.out.println(parkAttendance); //0
            System.out.println(++parkAttendance); //1
            System.out.println(parkAttendance); //1
            System.out.println(parkAttendance--); //1
            System.out.println(parkAttendance); //0
        }

        System.out.println("--------------------------------------------------------------");
        //binary arithmetic operators
        {
            int price = 2 * 5 + 3 * 4 - 8;
            System.out.println(price); //14
            price = 2 * (( 5 + 3 ) * 4 - 8);
            System.out.println(price); //48
        }
        System.out.println("--------------------------------------------------------------");

        //Division and modulus
        {
            System.out.println(9/3); //3
            System.out.println(9%3); //0
            System.out.println();
            System.out.println(10/3); //3
            System.out.println(10%3); //1
            System.out.println();
            System.out.println(11/3); //3
            System.out.println(11%3); //2
            System.out.println();
            System.out.println(12/3); //4
            System.out.println(12%3); //0
        }

        //Numeric promotion rule
        {
            {
                int x = 1;
                long y = 33;
                var z = x * y; //z is long
            }
            {
                double x = 39.21;
                //float y = 2.1; //does not compile
                float y = 2.1f;
                var z = x + y; //z is double
            }
            {
                short x = 10;
                short y = 3;
                var z = x * y; //x and y are promoted to int before the operation so z is int
                short zz = (short)(x * y); //cast the whole operation
            }
            {
                short w = 14;
                float x = 13;
                double y = 30;
                var z = w * x / y; //z is double
            }
        }

        //Assignment operator
        {
            int feed = 5;
        }

        //casting values
        {
            int fur = (int)5;
            int hair = (short)5;
            String type = (String) "Jiro";
            short tail = (short)(3+4);
            long  feathers = (long)4f;

            //float egg = 2.0 / 9; //does not compile
            float egg1 = (float)2.0 / 9;
            float egg2 = (float)(2.0 / 9);

            //int tadpole = (int)5 * 5L; //does not compile
            int tadpole1 = (int)5 * (int)5L;
            int tadpole2 = (int)((int)5 * 5L);
            int tadpole3 = (byte)((int)5 * 5L);

            short uu = 5+7; //always short

            //short frog = 3 - 2.0; //does not compile
            short frog1 = 3 - (short)2.0;
            short frog2 = (short)(3 - 2.0);

            //int fish = 1.0; //does not compile
            int fish = (int)1.0;

            //short bird = 1921222; //does not compile
            short bird = (short)1921222;

            //int mammal = 9f; //does not compile
            int mammal = (short)9f;

            //long reptile = 192_301_398_193_810_323; //does not compile
            //long reptile = (long)192_301_398_193_810_323; //does not compile
            long reptile = 192_301_398_193_810_323L; //or l

            short mouse = 10;
            short hamster = 3;
            //short capybara = mouse * hamster; //does not compile
            //short capybara = (short)mouse * hamster; //does not compile
            //short capybara = 1 + (short)(mouse * hamster); //does not compile
            short capybara = (short)(mouse * hamster);
        }

        {
            byte hat = 1;

            byte i = 7;
            byte j = 10;
            byte k = (byte)(i * j);
            byte gloves = 7 * 10; //no need to cast (values)
            //byte glove2 = 7 * 100; //does not compile
            byte gloves3 = (byte)(7 * 100);


            short scarf = 5;
            short boots = 2 + 1;
            //short boots = 2 + hat; //does not compile
            short boots2 = (short)(2 + hat);

        }

        System.out.println("-----------------------------------------------------------------------------------------");

        //compound assignment operator
        {
            int camel = 2, giraffe = 3;
            camel = camel * giraffe; //simple assignment operator
            System.out.println(camel);
            camel *= giraffe; //compound assignment operator
            System.out.println(camel);

            long goat = 10;
            int sheep = 5;
            //sheep = sheep * goat; //does not compile
            sheep = (int)(sheep * goat);
            System.out.println(sheep);
            sheep *= goat; //no need to cast, the compiler will automatically cast the resulting value to the data type of the value on the left side of the compound operator.
            System.out.println(sheep);
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        {
            long wolf = 5;
            long coyote = (wolf=3);
            System.out.println(wolf); //3
            System.out.println(coyote); //3

            boolean healthy = false;
            if(healthy = true)
                System.out.println("Healthy");
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        {
            int pig = (short)4;
            pig = pig++; //does not affect pig value
            //pig++; //increment pig value
            long goat = (int)2;
            goat -= 1.0;
            System.out.println(pig + " - " + goat);//4 - 1
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        {
            int b = 4;
            System.out.println(b++); //4
            System.out.println(b); //5
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(null == null); //true
    }
}