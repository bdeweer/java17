package certification.chapter9;

import java.io.FileNotFoundException;
import java.util.*;

public class Test {

    public static void main(String[] args) {


        String [] values = {"Un", "Deux", "Trois", "Quatre"};

        System.out.println(values); //[Ljava.lang.String;@4563e9ab
        System.out.println(Arrays.toString(values)); //String representationmouse

        System.out.println("-----------------------------------------------------------------------------------------");

        List<?> q = List.of("mouse", "parrot"); //list of objects, not String
        //q.removeIf((String s) -> s.length() == 4); does not compile
        //q.removeIf(String::isEmpty); //does not compile
        //q.removeIf(s -> s.length() ==4); //does not compile

        var v = List.of("mouse", "parrot"); // v is List<String> - deduce the type from the context
        //v.removeIf(String::isEmpty); //UnsupportedOperationException
        //v.removeIf(s -> s.length() ==4); //UnsupportedOperationException

        System.out.println("-----------------------------------------------------------------------------------------");


        //HashSet<Number> hs = new HashSet<Integer>();
        HashSet<? super ClassCastException> set2 = new HashSet<Exception>(); //lower bound, super class generic type -
        //hs.add(new Exception()); //does not compile

        //List<> list = new ArrayList<String>(); //does not compile
        //List<Object> objects = new ArrayList<? extends Object>(); //does not compile

        Map<String, ? extends Number> hm = new HashMap<String, Integer>();

        HashSet<? extends Number> hs2 = new HashSet<Integer>(); //upper bound, any class that extends Number or Number itself can be used as the formal parameter type.
        //hs2.add(new Integer(4)); does not compile!


        //The generic type must be Exception or a subclass of Exception since this is an upper bound
        Helper.printException(new FileNotFoundException("A"));
        Helper.printException(new Exception("B"));
        Helper.<NullPointerException>printException(new NullPointerException("C"));

        var list = List.of(1,2,3);
        var set = Set.of(1,2,3);
        var map = Map.of(1,2,3,4);
        list.forEach(System.out::println);
        set.forEach(System.out::println);
        map.keySet().forEach(System.out::println);
        map.values().forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        Comparator<Integer> c1 = (o1, o2) -> o2 - o1;
        Comparator<Integer> c2 = Comparator.naturalOrder();
        Comparator<Integer> c3 = Comparator.reverseOrder();

        var list2 = Arrays.asList(5,4,7,2);

        Collections.sort(list2, c2);
        Collections.reverse(list2);
        Collections.reverse(list2);

        System.out.println(list2);
        System.out.println(Collections.binarySearch(list2, 2));


        System.out.println("-----------------------------------------------------------------------------------------");


        var s1 = new Sorted(88, "a");
        var s2 = new Sorted(55, "b");

        var t1 = new TreeSet<Sorted>();
        t1.add(s1);
        t1.add(s2);

        var t2 = new TreeSet<Sorted>(s1); //pass a dedicated comparator
        t2.add(s1);
        t2.add(s2);

        System.out.println(t1 + " " + t2);

        System.out.println("-----------------------------------------------------------------------------------------");

        var map2 = Map.of(1,2,3,6);
        var list3 = List.copyOf(map2.entrySet()); // 1 3

        List<Integer> one = List.of(8,16,2);
        var copy = List.copyOf(one);
        var copyOfCopy = List.copyOf(copy);
        var thirdCopy = new ArrayList<>(copyOfCopy);

        //list3.replaceAll(x -> x * 2);
        //one.replaceAll(x -> x * 2);
        thirdCopy.replaceAll(x -> x * 2);

        System.out.println("-----------------------------------------------------------------------------------------");
        Map m = new HashMap();
        m.put(123, "456");
        m.put("abc", "def");
        System.out.println(m.containsKey("123"));;

        System.out.println("-----------------------------------------------------------------------------------------");

        var z = new LinkedList<>();
        z.add(10);
        z.add(12);
        z.remove(1);
        System.out.println(z);
    }


    static class Helper {
        public static <U extends Exception> void printException(U u){
            System.out.println(u.getMessage());
        }
    }

    static record Sorted(int num, String text) implements Comparable<Sorted>, Comparator<Sorted>{

        @Override
        public int compareTo(Sorted o) {
            return text.compareTo(o.text);
        }

        @Override
        public int compare(Sorted o1, Sorted o2) {
            return o1.num - o2.num;
        }

        @Override
        public String toString() {
            return "" + num ;
        }
    }
}