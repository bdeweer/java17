package certification.chapter4;

import java.time.*;

public class Part17 {

    public static void main(String[] args) {

        var date = LocalDate.of(2022, Month.MARCH, 13);
        var time = LocalTime.of(1,30);
        var zone = ZoneId.of("US/Eastern");
        var dateTime = ZonedDateTime.of(date, time, zone);
        System.out.println(dateTime); //2022-03-13T01:30-05:00[US/Eastern]

        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); //2022-03-13T01:30-05:00[US/Eastern]

        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); //2022-03-13T04:30-04:00[US/Eastern]

        System.out.println("-----------------------------------------------------------------------------------------");

        var date2 = LocalDate.of(2022, Month.MARCH, 13);
        var time2 = LocalTime.of(2,30);
        var zone2 = ZoneId.of("US/Eastern");
        var dateTime2 = ZonedDateTime.of(date2, time2, zone2);
        //2022-03-13T03:30-04:00[US/Eastern]
        System.out.println(dateTime2); //Java known that there is no 2:30 a.m that night and switches over to the appropriate GMT offset.
    }
}