package certification.chapter9;

import java.util.*;

public class Part9 {

    public static void main(String[] args) {

        //Using the Map interface
        var map = Map.of("key1", "value1", "key2", "value2");
        //map.put("key3", "value2"); //UnsupportedOperationException
        System.out.println(map);

        var map2 = Map.copyOf(map);
        //map2.put("key3", "value2"); //UnsupportedOperationException
        System.out.println(map2);

        var map3 = Map.ofEntries(
                Map.entry("key1", "value1"),
                Map.entry("key2", "value2")
        );

        System.out.println(map3);
        //map3.put("k", "v"); //UnsupportedOperationException

        System.out.println("-----------------------------------------------------------------------------------------");

        //HashMap
        Map<String, String> map4 = new HashMap<>();
        map4.put("koala", "bomboo");
        map4.put("lion", "meat");
        map4.put("giraffe", "leaf");
        String food = map4.get("koala");
        System.out.println(food); //bomboo
        for(String key : map4.keySet()){
            System.out.println(key + ","); //koala,giraffe,lion, //arbitrary order
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        //TreeMap
        Map<String, String> map5 = new TreeMap<>();
        //Map<String, String> map5 = new TreeMap<>((o1, o2) -> 0);
        map5.put("koala", "bomboo");
        map5.put("lion", "meat");
        map5.put("giraffe", "leaf");
        String food2 = map5.get("koala");
        System.out.println(food2);

        for(Map.Entry<String, String> entry : map5.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        for(String key : map5.keySet()){
            System.out.println(key + ","); //giraffe,koala,lion, //natural order
        }

        for(String value : map5.values()){
            System.out.println(value + ","); //leaf,bomboo,meat, (order of keys)
        }

        //System.out.println(map5.contains("lion")); //doesn't compile
        System.out.println(map5.containsKey("lion")); //true
        System.out.println(map5.containsValue("lion")); //false
        System.out.println(map5.size()); //3

        map5.clear();
        System.out.println(map5.size()); //0
        System.out.println(map5.isEmpty()); //true
    }
}