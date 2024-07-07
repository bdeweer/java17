package certification.chapter11.exception;

import java.io.IOException;

public class Test3 {

    public static void main(String[] args) {

        try {
            testChecked();
        }catch(IOException e){

        }

        testUnChecked();
    }


    public static void testChecked() throws IOException {
    }

    public static void testUnChecked() throws RuntimeException {
    }

}
