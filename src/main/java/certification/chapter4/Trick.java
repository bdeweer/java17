package certification.chapter4;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

public class Trick {

    public static void main(String[] args) {

        StringBuilder test = new StringBuilder("12345");
        System.out.println(test.replace(2,4, "6"));

        var numbers = "012345678".indent(1);
        System.out.println(numbers);
        numbers = numbers.stripLeading();
        System.out.println(numbers);

        System.out.println(numbers.substring(1,3));

        //System.out.println(numbers.substring(7));

        System.out.println("la");

        var base = "ewe\nsheep\\t";
        System.out.println(base);

        int indent = base.indent(2).length();
        System.out.println(base.indent(2));

        System.out.println(base.length());
        System.out.println(indent);

        System.out.println(base.translateEscapes().length());

        String s1 = """
                purr""";
        String s2 = "";

        s1.toUpperCase();
        s1.trim();
        s1.substring(1,3);

        s1 += "two";

        s2+= 2;
        s2 += 'c';
        s2 += false;

        if(s2.equals("2cfalse"))
            System.out.println("equals");

        System.out.println(s2.length());

        var date = LocalDate.of(2022, Month.MARCH, 13);
        var time = LocalTime.of(1,30);
        var zone = ZoneId.of("US/Eastern");
        var dateTime1 = ZonedDateTime.of(date, time, zone);
        var dateTime2 = dateTime1.plus(1, ChronoUnit.HOURS);

        long diff = ChronoUnit.HOURS.between(dateTime1, dateTime2);
        int hour = dateTime2.getHour();
        boolean offset = dateTime1.getOffset() == dateTime2.getOffset();

        System.out.println("diff = " + diff);
        System.out.println("hpur = " + hour);
        System.out.println("offset = " + offset);

    }
}
