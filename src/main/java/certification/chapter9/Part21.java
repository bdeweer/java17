package certification.chapter9;

import java.util.ArrayList;
import java.util.List;

public class Part21 {

    public static void main(String[] args) {

        List<String> keywords = new ArrayList<>();
        keywords.add("Java");
        //printList(keywords); //does not compile
        printList2(keywords);

        List<?> x1 = new ArrayList<String>(); //type is List, can assign List of anything, get() returns Object type
        //Java doesn't know what type really is so it's not possible to add element

        var x2 = new ArrayList<>(); //type is ArrayList, can only assign List<Object>, get() returns Object type
    }

    public static void printList(List<Object> list){
        for(Object o : list){
            System.out.println(o);
        }
    }

    public static void printList2(List<?> list){
        for(String o : (List<String>)list){
            System.out.println(o);
        }
    }
}
