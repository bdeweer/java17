package certification.chapter4;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Part18 {

    public static void main(String[] args) {


        System.out.println("-----------------------------------------------------------------------------------------");

        var base = "ewe\nsheep\\t"; // \\t take 2 positions
        int length = base.length();
        System.out.println(length); //11

        System.out.println(base.indent(2));

        System.out.println(base.indent(2).length()); //16 (15 +1 normalization)

        System.out.println(base.translateEscapes());
        System.out.println(base.translateEscapes().length()); //10 (9+1 normalization)

        System.out.println("-----------------------------------------------------------------------------------------");

        //A revoir : rien compris - String literals rien compris non plus

        String [] s1 = {"Camel", "QPeacock", "Llama"};
        String [] s2 = {"Camel", "Llama", "Peacock"};
        String [] s3 = {"Camel"};
        String [] s4 = {"Camel", null};

        System.out.println(Arrays.compare(s1, s2)); //4 (M-N-O-P)
        System.out.println(Arrays.mismatch(s1, s2)); //1
        System.out.println(Arrays.compare(s3, s4)); //-1
        System.out.println(Arrays.mismatch(s3, s4)); //1
        System.out.println(Arrays.compare(s4, s4)); //0
        System.out.println(Arrays.mismatch(s4, s4)); //-1


        System.out.println("-----------------------------------------------------------------------------------------");

        var puzzle = new StringBuilder("Java");
        //puzzle.reverse();
        System.out.println(puzzle);
        System.out.println(puzzle.append("vaJ$").delete(0,3));

        //System.out.println(puzzle.append("vaJ$").delete(0,3));

        System.out.println("-----------------------------------------------------------------------------------------");


        var dateTime1 = ZonedDateTime.of(LocalDate.of(2022, Month.MARCH, 13), LocalTime.of(1,20), ZoneId.of("US/Eastern"));
        var dateTime2 = dateTime1.plus(1, ChronoUnit.HOURS);

        System.out.println(dateTime1); //01:20
        System.out.println(dateTime2); //03:20
        System.out.println(ChronoUnit.HOURS.between(dateTime1, dateTime2)); //only one hour !!!

    }
}
