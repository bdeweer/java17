package certification.chapter13.part11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex3 {

    public static void main(String[] args) {

        Ex3 ex3 = new Ex3();
        System.out.println(ex3.addValues(IntStream.of(1,2,3,4,5)));
        System.out.println(ex3.addValuesBeter(IntStream.of(1,2,3,4,5)));
    }

    public List<Integer> addValues(IntStream source){
        var data = Collections.synchronizedList(new ArrayList<Integer>());
        source.filter(s -> s % 2 == 0).forEach(data::add);
        return data;
    }

    public List<Integer> addValuesBeter(IntStream source){
        return source.filter(s -> s %2 == 0).boxed().collect(Collectors.toList());
    }
}
