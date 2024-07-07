package certification.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchStudy {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(6,9,1,8);
        Collections.sort(ints);

        System.out.println(ints);

        System.out.println(Collections.binarySearch(ints, 6));

        System.out.println(Collections.binarySearch(ints, 3)); //-2 (minus 1 to the negative index where the value would need to be inserted)

        var names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c = Comparator.reverseOrder();

        var index = Collections.binarySearch(names, "Hoppy", c);
        System.out.println(index); //-1 result is undefined due to improperly sorted list
    }
}
