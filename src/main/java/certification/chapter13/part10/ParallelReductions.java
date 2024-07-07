package certification.chapter13.part10;

import java.util.List;

public class ParallelReductions {

    public static void main(String[] args) {

        System.out.println(List.of(1,2,3,4,5,6).parallelStream().findFirst().get());

        List.of(1,2,3,4,5,6).stream().unordered();

        System.out.println(List.of('w','o','l','f').parallelStream().reduce("", (s1,c) -> s1+c, (s2,s3) -> s2 + s3));

        for (int i = 0; i < 1000000; i++) {
            Integer reduce = List.of(1, 2, 3, 4, 5, 6).parallelStream().reduce(0, (a, b) -> (a - b));
            if(reduce != 3){
                System.out.println(reduce);
            }
        }
    }
}