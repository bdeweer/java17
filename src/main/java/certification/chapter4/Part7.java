package certification.chapter4;

import java.util.Arrays;

public class Part7 {

    public static void main(String[] args) {

        int [] numbers = {2,4,6,8};

        System.out.println(Arrays.binarySearch(numbers, 2)); //0
        System.out.println(Arrays.binarySearch(numbers, 4)); //1
        System.out.println(Arrays.binarySearch(numbers, 1)); //-1
        System.out.println(Arrays.binarySearch(numbers, 3)); //-2 : (-(1))-1
        System.out.println(Arrays.binarySearch(numbers, 9)); //-5 : (-(4))-1

        int [] numbers2 = {3,2,1};
        System.out.println(Arrays.binarySearch(numbers2, 2)); //unpredictable output
        System.out.println(Arrays.binarySearch(numbers2, 3)); //unpredictable output


        var arr = new String[] {"PIG", "pig", "123"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); //[123, PIG, pig]
        System.out.println(Arrays.binarySearch(arr, "Pippa")); //-3
    }
}
