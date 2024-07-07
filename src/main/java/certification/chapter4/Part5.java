package certification.chapter4;

import java.util.Arrays;

public class Part5 {

    public static void main(String[] args) {

        int [] numbers = new int [3]; //numbers is a reference variable
        int moreMoreNumbers [] = new int []{68,68,69};
        int [] moreNumbers = {67,68,69}; //shortcut (anonymous array)
        int moreMoreMoreNumbers []; //c-style

        int [] ids, types; //two arrays
        int ids2 [], types2; //one array

        String [] bugs = {"cricket", "beetle", "ladybug"};
        String [] alias = bugs;

        System.out.println(bugs.equals(alias)); //true
        System.out.println(bugs.toString());
        System.out.println(alias.toString());

        System.out.println(Arrays.toString(bugs)); //nicely prints an array

        String names []; //This code never instantiated the array

        String [] strings = {"stringValue"};
        Object [] objects = strings;
        String [] againStrings = (String []) objects;
        againStrings[0] = "jiro";
        //againStrings[1] = new StringBuilder(); //does not compile
        //objects[0] = new StringBuilder(); //ArrayStoreException at runtime

        String [] mammals = {"monkey", "chimp", "donkey"};
        System.out.println(mammals.length); //not length() !
        System.out.println(mammals[0]);
        System.out.println(mammals[1]);
        System.out.println(mammals[2]);

        var numbers2 = new int [10];
        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = i + 5;
        }

        System.out.println(Arrays.toString(numbers2));


        //numbers2[10] = 3; //ArrayIndexOutOfBoundsException
        //numbers2[numbers2.length] = 5; //ArrayIndexOutOfBoundsException

        for (int i = 0; i <= numbers2.length; i++) { //<=!! => //ArrayIndexOutOfBoundsException
            //numbers2[i] = i+5;
        }
    }
}
