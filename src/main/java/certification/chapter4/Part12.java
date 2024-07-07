package certification.chapter4;

import java.time.*;

public class Part12 {

    public static void main(String[] args) {

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());

        var date1 = LocalDate.of(2022, Month.JANUARY, 20);
        var date2 = LocalDate.of(2022, 1, 20); //same

        var time1 = LocalTime.of(6,15);
        var time2 = LocalTime.of(6,15, 30);
        var time3 = LocalTime.of(6,15,30, 200);

        var dateTime1 = LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15, 30);
        var dateTime2 = LocalDateTime.of(date1, time1);

        var zone = ZoneId.of("US/Eastern");
        var zoned1 = ZonedDateTime.of(2022, 1, 20, 6, 15, 30, 200, zone);
        var zoned2 = ZonedDateTime.of(date1, time1, zone);
        var zoned3 = ZonedDateTime.of(dateTime1, zone);

        //var d = new LocalDate(); //does not compile
        //var d = LocalDate.of(2022, Month.JANUARY, 32); //DateTimeException

    }
}
