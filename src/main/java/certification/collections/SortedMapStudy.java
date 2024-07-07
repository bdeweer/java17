package certification.collections;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapStudy {

    public static void main(String[] args) {

        SortedMap<Integer, String> smap = new TreeMap<>();

        smap.put(75, "Paris");
        smap.put(50, "Manche");
        smap.put(59, "Nord");
        smap.put(33, "Gironde");
        smap.put(83, "Var");


        System.out.println("content of sorted map : " + smap);
        System.out.println("first element in map : " + smap.firstKey());
        System.out.println("last element in map : " + smap.lastKey());
        System.out.println("element before number 59 : " + smap.headMap(59));
        System.out.println("element after number 59 : " + smap.tailMap(59)); //including 59
        System.out.println("element between 50 and 75 : " + smap.subMap(50, 75)); //including 50

        //Data structures that involve sorting do not allow null values
        smap.put(null, "Null"); //runtime exception

    }
}
