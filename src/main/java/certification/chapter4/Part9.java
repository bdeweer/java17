package certification.chapter4;

import java.util.Arrays;

public class Part9 {

    public static void main(String[] args) {

        System.out.println(Arrays.mismatch(new int [] {1}, new int [] {1})); //-1
        System.out.println(Arrays.mismatch(new String [] {"a"}, new String [] {"A"})); //0
        System.out.println(Arrays.mismatch(new int [] {1, 2}, new int [] {1})); //1
    }
}