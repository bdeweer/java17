package certification.chapter9;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Part10 {

    public static void main(String[] args) {

        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'a');
        map.put(2, 'b');
        map.put(3, 'c');
        map.forEach((k,v) -> System.out.println(v));

        //or
        map.values().forEach(System.out::println);

        //or
        map.entrySet().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        System.out.println("-----------------------------------------------------------------------------------------");

        //Getting values safely
        Map<Character, String> map2 = new HashMap<>();
        map2.put('x', "spot");
        System.out.println("X marks the " + map2.get('x'));
        System.out.println("X marks the " + map2.getOrDefault('x', "default spot"));
        System.out.println("Y marks the " + map2.get('y'));
        System.out.println("Y marks the " + map2.getOrDefault('y', "default value"));

        System.out.println("-----------------------------------------------------------------------------------------");
        //Replacing values
        Map<Integer, Integer> map3 = new HashMap<>();
        map3.put(1,2);
        map3.put(2,4);
        Integer original = map3.replace(2,10);
        System.out.println(original); //4
        System.out.println(map3); //{1=2, 2=10}

        BiFunction<Integer, Integer, Integer> biFunction = (k,v) -> k + v;
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        map3.replaceAll(biFunction); //or binaryOperator
        System.out.println(map3); //{1=3, 2=12}

        System.out.println("-----------------------------------------------------------------------------------------");
        //PutIfAbsent
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);
        System.out.println(favorites); //{Tom=null, Jenny=Bus Tour}
        System.out.println(favorites.putIfAbsent("Jenny", "Tram")); //Bus Tour
        System.out.println(favorites.putIfAbsent("Sam", "Tram")); //null
        System.out.println(favorites.putIfAbsent("Tom", "Tram")); //null
        System.out.println(favorites); //{Tom=Tram, Jenny=Bus Tour, Sam=Tram}

        System.out.println("-----------------------------------------------------------------------------------------");

        //Merging data
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        Map<String, String> favorites2 = new HashMap<>();
        favorites2.put("Jenny", "Bus Tour");
        favorites2.put("Tom", "Tram");
        System.out.println("MERGE");
        System.out.println(favorites2); //{Tom=Tram, Jenny=Bus Tour}

        String jenny = favorites2.merge("Jenny", "Skyride", mapper);
        System.out.println(jenny); //Bus Tour - Renvoie la valeur mise à jour
        System.out.println(favorites2); //{Tom=Tram, Jenny=Bus Tour}
        String tom = favorites2.merge("Tom", "Skyride", mapper);
        System.out.println(tom); //Skyride - Renvoie la valeur mise à jour
        System.out.println(favorites2); //{Tom=Skyride, Jenny=Bus Tour}
        favorites2.merge("Jiro", "Shiba", mapper); //mapping function not called
        System.out.println(favorites2); //{Tom=Skyride, Jenny=Bus Tour, Jiro=Shiba}

        System.out.println("-----------------------------------------------------------------------------------------");
        Map<String, String> favorites3 = new HashMap<>();
        favorites3.put("Sam", null);
        String sam = favorites3.merge("Sam", "Skyride", mapper); //mapping function not called
        System.out.println(sam); //Skyride
        tom = favorites3.merge("Tom", "Skyride", mapper);
        System.out.println(tom); //Skyride
        System.out.println(favorites3); //{Tom=Skyride, Sam=Skyride}

        System.out.println("-----------------------------------------------------------------------------------------");
        BiFunction<String, String, String> mapper2 = (v1, v2) -> null;
        Map<String, String> favorites4 = new HashMap<>();
        favorites4.put("Jenny", "Bus Tour");
        favorites4.put("Tom", "Bus Tour");
        System.out.println(favorites4); //{Tom=Bus Tour, Jenny=Bus Tour}

        favorites4.merge("Jenny", "Skyride", mapper2); //remove if value is null!
        favorites4.merge("Sam", "Skyride", mapper2);

        System.out.println(favorites4); //{Tom=Bus Tour, Sam=Skyride} !!!!!!!!!
    }
}
