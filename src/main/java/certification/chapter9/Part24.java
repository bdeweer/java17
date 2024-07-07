package certification.chapter9;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part24 {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<String>();
        strings.add("tweet");

        List<Object> objects = new ArrayList<Object>(strings);

        addSound(strings);
        addSound(objects);

        System.out.println("-----------------------------------------------------------------------------------------");

        List<? super IOException> exceptions = new ArrayList<>(); //Acceptes toutes les classes qui sont des IOException ou enfant
        //exceptions.add(new Exception()); //does not compile
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());

        List<? super Exception> a = new ArrayList<>();
        a.add(new IOException());


    }

    public static void addSound(List<? super String> list){
           list.add("quack");
    }
}
