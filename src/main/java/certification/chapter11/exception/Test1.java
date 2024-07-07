package certification.chapter11.exception;

import java.io.IOException;

public class Test1 {

    public void whatHappensNext() throws IOException {

        System.out.println("its ok");
        //throw new Exception(); //KO
        //throw new IllegalArgumentException(); //OK
        //throw new RuntimeException(); //OK
        throw new IOException(); //OK




    }

}
