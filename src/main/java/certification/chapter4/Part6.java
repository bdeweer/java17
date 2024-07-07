package certification.chapter4;

import java.util.Arrays;

public class Part6 {

    public static void main(String[] args) {

        int [] numbers = {6,9,1};
        System.out.println(numbers); //[I@4563e9ab
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println(Arrays.toString(numbers)); //[1, 6, 9]

        String [] strings = {"10", "9", "100"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings)); //[10, 100, 9]
    }
}
