package certification.collections;

import java.util.*;

public class CollectionsStudy {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(0,1,2);
        System.out.println(Collections.max(ints));

        List<String> strs = Arrays.asList("zero", "one", "two");
        System.out.println(Collections.max(strs));

        List<Number> nums = Arrays.asList(0,1,2,3.13);
        //System.out.println(Collections.max(nums)); //compile-time error since Number does not implement Comparable


        var numbers = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        Map<Long, List<Integer>> mapLists = new HashMap<Long, List<Integer>>();

        List<Integer> listShort = new ArrayList<>();
        Map<Long, List<Integer>> mapListsShort = new HashMap<>();

        Collection<String> collection = new ArrayList<>();
        System.out.println(collection.add("Sparrow"));
        System.out.println(collection.add("Sparrow"));

        Collection<String> set = new HashSet<>();
        System.out.println(set.add("Sparrow"));
        System.out.println(set.add("Sparrow"));

        //Removing elements
        Collection<String> birds = new ArrayList<>();

        System.out.println(birds.isEmpty());
        System.out.println(birds.size());

        birds.add("hawk");
        birds.add("hawk");

        System.out.println(birds.isEmpty());
        System.out.println(birds.size());

        System.out.println(birds.remove("cardinal"));
        System.out.println(birds.remove("hawk"));

        System.out.println(birds);

        System.out.println(birds.contains("hawk"));
        System.out.println(birds.contains("robin"));

        birds.clear();
        System.out.println(birds.isEmpty());
        System.out.println(birds.size());

        Collection<String> jobs = new ArrayList<>();
        jobs.add("Magician");
        jobs.add("Assistant");
        System.out.println(jobs);

        jobs.removeIf(j -> j.startsWith("A"));

        System.out.println(jobs);

        Collection<String> set3 = new HashSet<>();
        set3.add("Wand");
        set3.add("");
        set3.removeIf(String::isEmpty);
        System.out.println(set3);

        Collection<String> cats = List.of("Annie", "Ripley");
        cats.forEach(System.out::println);
        cats.forEach(c -> System.out.println(c));

        var list1 = List.of(1,2);
        var list2 = List.of(2,1);

        var set1 = Set.of(1,2);
        var set2 = Set.of(2,1);

        System.out.println(list1.equals(list2)); //List care about order
        System.out.println(set1.equals(set2)); //Set is not sensitive about order
        System.out.println(list1.equals(set1)); //types are different

        var heights = new ArrayList<Integer>();
        heights.add(null);
        System.out.println(heights.get(0)); //null
        //int h = heights.get(0); //Unboxing null throw NullPointerException



    }
}
