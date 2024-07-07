package certification.chapter13.part8;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollections {

    public static void main(String[] args) {


        List<Integer> favNumbers = new CopyOnWriteArrayList<>(List.of(4,3,42));

        for(var n : favNumbers){
            System.out.println(n + " ");
            favNumbers.add(n+1);
            System.out.println();
            System.out.println("Size : " + favNumbers.size());
        }
        System.out.println(favNumbers);


        Collection<Integer> integers = Collections.synchronizedCollection(List.of(4, 3, 42)); //Immutable collection


    }
}
