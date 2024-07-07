package certification.chapter2;

public class Part3 {

    public static void main(String[] args) {


        {
            boolean eyesClosed = true;
            boolean breathingSlowly = true;

            boolean resting = eyesClosed | breathingSlowly;
            boolean asleep = eyesClosed & breathingSlowly;
            boolean awake = eyesClosed ^ breathingSlowly;
            System.out.println(resting); //true
            System.out.println(asleep); //true
            System.out.println(awake); //false
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        {
            int hour = 10;
            boolean zooOpen = true || (hour <4);
            System.out.println(zooOpen); //true
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        {
            int rabbit = 6;
            boolean bunny = (rabbit >= 6) || (++rabbit <=7);
            System.out.println(bunny); //true
            System.out.println(rabbit); //6
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        {
            int owl = 5;
            int food1 = owl < 4 ? owl > 2 ? 3 : 4 : 5;
            System.out.println(food1); //5

            int stripes = 7;
            System.out.println(stripes > 5 ? 21 : "Zebra"); //21

            //int animal = (stripes < 9) ? 3 : "Horse"; //does not compile

            int sheep = 1;
            int zzz = 1;
            int sleep = zzz<10 ? sheep++ : zzz++;
            System.out.println(sleep + "," + sheep + ","+zzz); //1,2,1

        }

        System.out.println("-----------------------------------------------------------------------------------------");
        {

            short height = 1, weight = 3;
            //short zebra = (byte) weight * (byte) height; //does not compile
        }

    }
}
