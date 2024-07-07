package tests.chapter5;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        //1
        List<String> museums = new ArrayList<>(1);
        museums.add("Natural History");
        museums.add("Science");
        museums.add("Art");
        System.out.println(museums.remove(2));
        System.out.println(museums);

        //2
        int [] numbers = new int[1];
        numbers[0] = 4;
        System.out.println(numbers);
        String bears [] = new String[]{};

        //4
        //List<String> strings = new ArrayList<?>(); //DNC
        var ints = new HashSet<Integer>();
        //Float flt = 5.0; DNC
        Float flt = 5.0f;
        Double dbl = 5.0;
        ints.add(2);
        ints.add(null);

        //6
        var q = new ArrayDeque<String>();
        q.offer("snowball");
        q.offer("minnie");
        q.offer("sugar");
        System.out.println(q.peek() + " " + q.peek() + " " + q.size());

        //46
        Comparator<Integer> c = (x,y) -> y - x;
        var intss = Arrays.asList(3,1,4);
        Collections.sort(intss, c);
        System.out.println(Collections.binarySearch(intss, 1, c )); // 2
        System.out.println(Collections.binarySearch(intss, 1)); //-1

        Set<Integer> setInt = new TreeSet<>();
        setInt.add(2);
        //setInt.add(null); //NPE
    }

    //24
    public static void throwOne(Collection<? extends RuntimeException> coll) throws Exception{
        var iter = coll.iterator();
        if(iter.hasNext()){
            throw iter.next();
        }
            //
    }
}

class PreSchool {
    record Blankie(String color){}

    public static void main(String[] args) {
        var list = Arrays.asList(new Blankie("pink"), new Blankie("blue"));

        list.stream().forEach(Blankie::color);
    }
}