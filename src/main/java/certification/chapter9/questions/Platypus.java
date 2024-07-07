package certification.chapter9.questions;

import java.util.*;

public record Platypus(String name, int breakLength) {

    @Override
    public String toString(){
        return "" + breakLength;
    }

    public static void main(String[] args) {
        Platypus p1 = new Platypus("Paula", 3);
        Platypus p2 = new Platypus("Peter", 5);
        Platypus p3 = new Platypus("Peter", 7);

        List<Platypus> list = Arrays.asList(p1, p2, p3);

        Collections.sort(list, Comparator.comparing(Platypus::name).thenComparing(Comparator.comparing(Platypus::breakLength).reversed()));

        System.out.println(list);



    }
}
