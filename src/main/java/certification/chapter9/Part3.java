package certification.chapter9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class Part3 {

    public static void main(String[] args) {

        //constructors
        var linked1 = new LinkedList<>();
        var linked2 = new LinkedList<>(linked1);

        var list1 = new ArrayList<>();
        var list2 = new ArrayList<>(list1);
        var list3 = new ArrayList<>(10);

        List<String> list = new ArrayList<>();
        list.add("SD");
        list.add(0, "NY");
        System.out.println(list); //[NY, SD]
        //System.out.println(list.get(1000)); //IndexOutOfBoundsException
        System.out.println(list.get(0)); //NY
        String replaced = list.set(1, "FL"); //returns the original : SD
        System.out.println(replaced); //SD
        System.out.println(list); //[NY, FL]
        list.remove("NY");
        System.out.println(list); //[FL]
        list.remove(0);
        System.out.println(list); //[]
        // list.set(0, "?"); //IndexOutOfBoundsException

        list.add("NO");
        list.add("CH");
        list.add("WH");

        list.replaceAll(v -> v + "A");
        System.out.println(list); //[NOA, CHA, WHA]

        list.sort(Comparator.naturalOrder());

        System.out.println(list); //[CHA, NOA, WHA]

    }
}
