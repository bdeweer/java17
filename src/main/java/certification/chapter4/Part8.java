package certification.chapter4;

import java.util.Arrays;

public class Part8 {

    public static void main(String[] args) {

        System.out.println(Arrays.compare(new int [] {1}, new int []{2})); //-1 : the first array is smaller

        //Arrays.compare(new int []{1}, new String [] {"a"}); //does not compile (different types)
    }
}
