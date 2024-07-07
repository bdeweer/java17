package certification.chapter10.part9;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Part9 {

    public static void main(String[] args) {

        System.out.println(IntStream.empty().summaryStatistics().getMax()); //-2147483648
        System.out.println(IntStream.empty().summaryStatistics().getMin()); //2147483647
        System.out.println(IntStream.empty().summaryStatistics().getCount()); //0
        System.out.println(IntStream.empty().summaryStatistics().getAverage()); //0.0
        System.out.println(IntStream.empty().summaryStatistics().getSum()); //0
    }

    private static int max(IntStream stream){
        return stream.max().orElseThrow(RuntimeException::new);
    }

    private static int range(IntStream ints){
        IntSummaryStatistics stats = ints.summaryStatistics();
        if(stats.getCount() == 0){
            throw new RuntimeException();
        }

        return stats.getMax() - stats.getMin();
    }
}