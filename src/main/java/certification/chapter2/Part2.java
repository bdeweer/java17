package certification.chapter2;

import java.io.File;

public class Part2 {

    public static void main(String[] args) {

        {
            //boolean monkey = true == 3; //does not compile
            //boolean ape = false != "Grape"; //does not compile
            //boolean gorilla = 10.2 == "Koko"; //does not compile

            boolean bear = true;
            boolean polar = (bear=true);
            System.out.println(bear); //true
            System.out.println(polar); //true

            var monday = new File("schedule.txt");
            var tuesday = new File("schedule.txt");
            var wednesday = tuesday;
            System.out.println(monday == tuesday); //false
            System.out.println(tuesday == wednesday); //true

            System.out.println(null==null); //true
        }

        System.out.println("------------------------------------------------------");

        //relational operator
        {
            int gibbonNumFeet = 2, wolfNumFeet = 4, ostrichNumFeet = 2;
            System.out.println(gibbonNumFeet < wolfNumFeet); //true
            System.out.println(gibbonNumFeet <= wolfNumFeet); //true
            System.out.println(gibbonNumFeet >= ostrichNumFeet); //true
            System.out.println(gibbonNumFeet > ostrichNumFeet); //false
        }

        System.out.println("-------------------------------------------------------");
        {
            Integer zooTime = Integer.valueOf(9);
            Number num = zooTime;
            Object obj = zooTime;

            openZoo(zooTime);
            openZoo(num);
            openZoo(obj); //instanceof Number !!

            System.out.println();

            System.out.println(null instanceof Object); //always return false
            Object noObjectHere = null;
            System.out.println(noObjectHere instanceof String); //false

            //System.out.println(null instanceof null); //does not compile

        }
    }

    public static void openZoo(Object time){

        if(time instanceof String){
            System.out.println("String");
        }

        if(time instanceof Number)
            System.out.println((Integer) time + "O'clock");
        else
            System.out.println(time);
    }
}
