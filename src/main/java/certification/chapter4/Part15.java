package certification.chapter4;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Part15 {

    public static void main(String[] args) {

        var daily = Duration.ofDays(1); //PT24H
        var hourly = Duration.ofHours(1); //PT1H
        var everyMinute = Duration.ofMinutes(1); //PT1M
        var everyTenSeconds = Duration.ofSeconds(10); //PT10S
        var everyMilli = Duration.ofMillis(1); //PT0.001S
        var everyNano = Duration.ofNanos(1); //PT0.000000001S

        var daily2 = Duration.of(1, ChronoUnit.DAYS);
        var hourly2 = Duration.of(1, ChronoUnit.HOURS); //PT1H
        var everyMinute2 = Duration.of(1, ChronoUnit.MINUTES); //PT1M
        var everyTenSeconds2 = Duration.of(10, ChronoUnit.SECONDS); //PT10S
        var everyMilli2 = Duration.of(1, ChronoUnit.MILLIS); //PT0.001S
        var everyNano2 = Duration.of(1, ChronoUnit.NANOS); //PT0.000000001S

        var one = LocalTime.of(5,15);
        var two = LocalTime.of(6,30);
        var date = LocalDate.of(2016, 1, 20);

        System.out.println(ChronoUnit.HOURS.between(one, two)); //1
        System.out.println(ChronoUnit.MINUTES.between(one, two)); //75
        //System.out.println(ChronoUnit.MINUTES.between(one, date)); //DateTimeException

        LocalTime time = LocalTime.of(3,12,45);
        System.out.println(time); //03:12:45
        LocalTime truncated = time.truncatedTo(ChronoUnit.MINUTES);
        System.out.println(truncated); //03:12

        var date2 = LocalDate.of(2022, 1, 20);
        var time2 = LocalTime.of(6,15);
        var dateTime = LocalDateTime.of(date2, time2);
        var duration = Duration.ofHours(6);

        System.out.println(dateTime.plus(duration)); //works as Period 2022-01-20T12:15
        System.out.println(time2.plus(duration)); //12:15
        //System.out.println(date2.plus(duration)); //UnsupportedTemporalTypeException

        System.out.println("-----------------------------------------------------------------------------------------");
        var date3 = LocalDate.of(2022, 1, 20);
        var time3 = LocalTime.of(6,15);
        var dateTime3 = LocalDateTime.of(date3, time3);
        var duration3 = Duration.ofHours(23);
        System.out.println(dateTime3.plus(duration3)); //2022-01-21T05:15
        System.out.println(time3.plus(duration3)); //05:15
        //System.out.println(date3.plus(duration3)); //UnsupportedTemporalTypeException

        var date4 = LocalDate.of(2022, 5, 25);
        var period4 = Period.ofDays(1);
        var days4 = Duration.ofDays(1);

        System.out.println(date4.plus(period4)); //2022-05-26
        //System.out.println(date4.plus(days4));  //UnsupportedTemporalTypeException
    }
}
