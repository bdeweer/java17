package certification.chapter9;

import java.util.ArrayList;
import java.util.List;

public class Part25 {

    public static void main(String[] args) {
        List<?> list1 = new ArrayList<A>();
        List<? extends A> list2 = new ArrayList<>();//Can contain A, B ,C (upper-bounded wildcard)

        List<? super A> list3 = new ArrayList<A>(); //The lowest type you can reference is A (low bounded wildcard)

        //List<? extends B> list4 = new ArrayList<A>(); //ne peut que contenir B ou C (upper-bounded wildcard)
        List<? super B> list5 = new ArrayList<A>(); //Allow A, B, Object (lower-bounded wildcard)
        //List<?> list6 = new ArrayList<? extends A>(); //unbounded wildcard : the type must be known when instanciating

    }
}

class A {}

class B extends A {}

class C extends B {}


