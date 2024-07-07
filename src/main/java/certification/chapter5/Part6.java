package certification.chapter5;

//import static java.util.Arrays;  //does not compile
//import java.util.Arrays;

import static java.util.Arrays.asList;
//static import java.util.Arrays; // does not compile

public class Part6 {

    public static void main(String[] args) {
        //Arrays.asList("one"); //does not compile
        asList("one");
    }
}
