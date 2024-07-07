package certification.collections;

import java.util.*;

public class ListStudy {

    public static void main(String[] args) {


        List<String> animals = new ArrayList<>(); //List are ordered and allow duplicates
        animals.add("lions");
        animals.add("pandas");
        animals.add("zebras");

        System.out.println(animals);

        String[] array = new String [] {"a", "b", "c"};
        List<String> asList = Arrays.asList(array); //can replace elements, keep pointer to the array
        List<String> of = List.of(array); //can't replace elements
        List<String> copy = List.copyOf(asList); //can't replace elements

        System.out.println(asList);
        System.out.println(of);
        System.out.println(copy);

        array[0] = "z";

        System.out.println(asList);
        System.out.println(of);
        System.out.println(copy);

        asList.set(0, "x"); //only asList can replace elements

        System.out.println(asList);
        System.out.println(of);
        System.out.println(copy);

        //asList.add("j"); //UnsupportedOperationException
        //of.add("j"); //UnsupportedOperationException
        //copy.add("j"); //UnsupportedOperationException

        var linked1 = new LinkedList<String>(); //No args constructor
        var linked2 = new LinkedList<String>(linked1); //Make a copy of an other LinkedList

        var list1 = new ArrayList<String>(); //No args constructor
        var list2 = new ArrayList<String>(list1); //Make a copy of an other ArrayList
        var list3 = new ArrayList<String>(10); //Create an ArrayList with an initial capacity

        var strings = new ArrayList<String>();
        strings.add("a");
        for(String s : strings){}

        var list = new ArrayList<>();
        list.add("a");
        //for(String s : list){} //Need to use Object instead of String


        List<String> list4 = new ArrayList<>();
        System.out.println(list4.add("Java")); //returns boolean value
        System.out.println(list4.add("Java")); //returns boolean value
        System.out.println(list4);
        list4.add(1, "Go"); //void
        System.out.println(list4);
        System.out.println(list4.get(1));
        System.out.println(list4.remove(1)); //Returns the removed element
        System.out.println(list4);
        System.out.println(list4.set(0, "C++")); //Returns the original value
        System.out.println(list4.remove(0)); //Remove element at a specified index
        System.out.println(list4);
        System.out.println(list4.set(0, "Perl")); //Returns the original value
        System.out.println(list4);

        var numbers = Arrays.asList(1,2,3);
        numbers.replaceAll(n -> n*2);
        System.out.println(numbers);

        Collection<String> c = new ArrayList<>();
        c.add("1");
        c.add("2");
        c.add("3");

        c.remove("1"); //returns boolean value

        System.out.println(c);


        //tricky
        var trickyList = new LinkedList<Integer>();
        trickyList.add(3);
        trickyList.add(2);
        trickyList.add(1);

        System.out.println(trickyList);

        trickyList.remove(); //Remove the head of the list (first element)
        trickyList.addFirst(3);
        System.out.println(trickyList);

        System.out.println(trickyList.remove(2));
        System.out.println(trickyList);
        System.out.println(trickyList.remove(Integer.valueOf(2)));
        System.out.println(trickyList);

        List<String> list5 = new ArrayList<>();
        list5.add("hawk");
        list5.add("robin");
        Object [] objectArray = list5.toArray();
        System.out.println(objectArray);
        String [] stringArray = list5.toArray(new String[0]);
        System.out.println(stringArray);

        list5.clear(); //does not affect the arrays

        System.out.println(objectArray.length);
        System.out.println(stringArray.length);


    }
}
