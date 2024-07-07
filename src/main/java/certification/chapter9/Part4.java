package certification.chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Part4 {

    public static void main(String[] args) {

        var numbers = Arrays.asList(1,2,3);
        UnaryOperator<Integer> unaryOperator = x -> x*2;
        numbers.replaceAll(unaryOperator);

        System.out.println(numbers); //[2, 4, 6]

        System.out.println("-----------------------------------------------------------------------------------------");

        List<String> list = new ArrayList<>();
        list.add("hawk");
        list.add("robin");
        Object[] objectArray = list.toArray();
        String[] stringArray = list.toArray(new String[0]);
        list.clear();
        System.out.println(objectArray.length); //no impact - 2
        System.out.println(stringArray.length); //no impact - 2

        System.out.println(Arrays.toString(objectArray)); //[hawk, robin]
        System.out.println(Arrays.toString(stringArray)); //[hawk, robin]
    }
}
