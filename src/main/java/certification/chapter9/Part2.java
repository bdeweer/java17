package certification.chapter9;

import java.util.*;

public class Part2 {

    public static void main(String[] args) {

        List<String> l1 = new ArrayList<>();
        List<String> l2 = new LinkedList<>();

        String [] array = new String[]{"a", "b", "c"};
        List<String> asList = Arrays.asList(array);
        List<String> asList2 = Arrays.asList("a", "b", "c");

        List<String> of = List.of(array);
        List<String> copy = List.copyOf(asList);


        System.out.println(asList); //[a, b, c]
        System.out.println(of); //[a, b, c]
        System.out.println(copy); //[a, b, c]

        System.out.println("-------------------------------------------");

        array[0] = "z";

        System.out.println(asList); //Arrays.asList can replace element [z, b, c]
        asList.set(1, "x"); //[z, x, c]
        System.out.println(asList);
        System.out.println(Arrays.toString(array)); //[z, x, c]
        System.out.println(of); //no impact [a, b, c]
        System.out.println(copy); //no impact [a, b, c]

        System.out.println("-------------------------------------------");

        asList.set(0, "x");
        //of.set(0,"x"); //UnsupportedOperationException
        //copy.set(0, "x"); //UnsupportedOperationException

        System.out.println(asList); // [x, x, c]

        //asList.add("T"); //UnsupportedOperationException
        // of.add("T"); //UnsupportedOperationException
        //copy.add("Z"); //UnsupportedOperationException

        //asList.remove("x"); //UnsupportedOperationException
        //of.remove("T"); //UnsupportedOperationException
        //copy.remove("Z"); //UnsupportedOperationException

        Collections.sort(asList);
        System.out.println(asList); //c, x, x]
        //Collections.sort(of); //UnsupportedOperationException
        //Collections.sort(copy); //UnsupportedOperationException
    }
}
