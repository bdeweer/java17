package certification.chapter4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Part13 {

    public static void main(String[] args) {

        var date = LocalDate.of(2022, Month.JANUARY, 20);
        System.out.println(date);

        date = date.plusDays(2);
        System.out.println(date);
        date = date.plusWeeks(1);
        System.out.println(date);
        date = date.plusMonths(1); //Java knows that 2022 is not a leap year and subtract one day : 28
        System.out.println(date);
        date = date.plusYears(5);
        System.out.println(date);

        var date2 = LocalDate.of(2024, Month.JANUARY, 20);
        var time = LocalTime.of(5,15);
        var dateTime = LocalDateTime.of(date2, time);
        System.out.println(dateTime);
        dateTime = dateTime.minusDays(1);
        System.out.println(dateTime);
        dateTime = dateTime.minusHours(10);
        System.out.println(dateTime);
        dateTime = dateTime.minusSeconds(30);
        System.out.println(dateTime);

        var date3 = LocalDate.of(2024, Month.JANUARY, 20);
        var time3 = LocalTime.of(5, 15);
        var dateTime2 = LocalDateTime.of(date3, time3).minusDays(1).minusHours(10).minusSeconds(30);
        System.out.println(dateTime2);
    }
}
