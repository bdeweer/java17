package certification.chapter4;

import java.time.*;

public class Part16 {

    public static void main(String[] args) {

        var now = Instant.now();
        //do something time-consuming
        for (long i = 0; i < 10000000000L; i++) {

        }


        var later = Instant.now();
        var duration = Duration.between(now, later);
        System.out.println(duration.toMillis());


        var date = LocalDate.of(2022, 5, 25);
        var time = LocalTime.of(11,55,00);
        var zone = ZoneId.of("US/Eastern");
        var zonedDateTime = ZonedDateTime.of(date, time, zone);
        var instant = zonedDateTime.toInstant(); //Get rid of the time zone and turns it into an Instant of time in GMT.
        System.out.println(zonedDateTime);
        System.out.println(instant);
    }

}
