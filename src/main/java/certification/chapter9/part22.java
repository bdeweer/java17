package certification.chapter9;

import java.util.ArrayList;
import java.util.List;

public class part22 {

    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        List<Number> l3 = new ArrayList<>();
        //ArrayList<Integer> l4 = new ArrayList<Number>(); //does not compile
        //ArrayList<Number> l5 = new ArrayList<Integer>(); //does not compile
        List<? extends Number> l6 = new ArrayList<Integer>(); //upper bound wildcard
        //Java doesn't know what type really is so it's not possible to add element
        //l6.add(1); //does not compile

        long total = total(l6);
        System.out.println(total);

        List<? super Integer> l7 = new ArrayList<Number>(); //lower bound wildcard
        l7.add(1);

    }

    public static long total(List<? extends Number> list){
        long count = 0;
        for(Number number : list){
            count += number.longValue();
        }
        return count;
    }
}