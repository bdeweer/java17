package certification.chapter14.part8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args)throws IOException {

        //It's not recommended to use System class in try with resources block
        try (
                var r = new BufferedReader(new InputStreamReader(System.in));
        ) {

            String put = r.readLine();
            System.out.println("You entered : " + put);

        }

        //it's better to do like this :

        var reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine(); //IOException here
        System.out.println("You entered : " + input);
    }
}
