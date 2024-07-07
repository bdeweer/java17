package certification.chapter4;

import java.time.*;

public class Part14 {

    public static void main(String[] args) {

        //var date1 = LocalDate.of(2022, 2, 31);
        //System.out.println(date1);

        var start = LocalDate.of(2022, Month.JANUARY, 1);
        var end = LocalDate.of(2022, Month.MARCH, 30);
        //performAnimalEnrichment(start, end); //bad

        var period = Period.ofMonths(1);

        System.out.println(start);
        System.out.println(end);
        System.out.println(period);
        performAnimalEnrichment(start, end, period); //good


        System.out.println(start);
        System.out.println(end);
        System.out.println(period);


        var wrong = Period.ofYears(1).ofWeeks(1); //every week

        System.out.println(Period.ofWeeks(4)); //P28D

        System.out.println(Period.ofMonths(3)); //P3M

        var date2 = LocalDate.of(2022, 1, 20);
        var time2 = LocalTime.of(6, 15);
        var dateTime = LocalDateTime.of(date2, time2);
        var period2 = Period.ofMonths(1);

        System.out.println(date2.plus(period2));
        System.out.println(dateTime.plus(period2));
        //System.out.println(time2.plus(period2)); //UnsupportedTemporalTypeException
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end){
        var upTo = start;
        while (upTo.isBefore(end)){
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plusMonths(1);
        }
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period){
        var upTo = start;
        while (upTo.isBefore(end)){
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plus(period);
        }
    }
}
