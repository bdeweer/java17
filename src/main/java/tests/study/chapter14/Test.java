package tests.study.chapter14;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


public class Test {

    public static void main(String[] args) throws IOException {

        Reader r;

        String line;
        var c = System.console();
        Writer w = c.writer();
        try(w){
            if((line = c.readLine("Enter your name : ")) != null)
                w.append(line);
            w.flush();
        }
    }
}


class Cowboy {
    private int space = 5;
    private double ship = space < 2 ? 3L : 10.0f;

    public void printMessage(){
        if(ship>1){
            System.out.println("Goodbye");
        }
        if(ship < 10 && space >=2)
            System.out.println("Hello");
        else System.out.println("See you again");
    }
    public static void main(String[] args) {
        new Cowboy().printMessage();

        List<?> n = new ArrayList<>();
        List<? super RuntimeException> o = new ArrayList<Exception>();

        var list = List.of("flower", "plant");
        Collections.sort(list);

        System.out.println(list);
    }
}

class Palace {

    public void openDrawbridge() throws Exception {
        try {
            throw new Exception("Problem");
        }catch(IOException e){

        }
    }
    public static void main(String[] args) {

    }
}


class Test3 {

    public static void main(String[] args) {

        Runnable r1 = () -> System.out.println("test");

        Runnable r2 = () -> Stream.of(1,2,3).parallel();
    }
}
