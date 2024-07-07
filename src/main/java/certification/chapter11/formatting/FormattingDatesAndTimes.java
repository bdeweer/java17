package certification.chapter11.formatting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class FormattingDatesAndTimes {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
        System.out.println(date.getDayOfMonth()); //20
        System.out.println(date.getDayOfWeek()); //return DayOfWeek - THURSDAY
        System.out.println(date.getMonth()); //returns Month - OCTOBER
        System.out.println(date.getYear()); //returns int - 2022
        System.out.println(date.getDayOfYear()); //returns int - 293

        LocalTime time = LocalTime.of(11,12,34);
        LocalDateTime dt = LocalDateTime.of(date, time);

        Locale.setDefault(new Locale("en", "US"));

        System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE)); //2022-10-20
        System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_TIME)); //11:12:34
        System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); //2022-10-20T11:12:34

        var f = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
        System.out.println(dt.format(f));
        System.out.println(f.format(dt)); //both order

        var dt2 = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);
        var formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
        System.out.println(formatter1.format(dt2)); //10/20/2022 06:15:30

        var formatter2 = DateTimeFormatter.ofPattern("MM_yyyy_-_dd");
        System.out.println(dt2.format(formatter2)); //10_2022_-_20

        var formatter3 = DateTimeFormatter.ofPattern("h:mm z");
        //System.out.println(formatter3.format(dt)); //DateTimeException because of the z (LocalDateTime does not have a time specified). Use ZonedDateTime for that

        //Adding text
        var f3 = DateTimeFormatter.ofPattern("MMMM dd, yyyy ");
        var f4 = DateTimeFormatter.ofPattern(" hh:mm");

        System.out.println(dt.format(f3) + "at" + dt.format(f4)); //October 20, 2022 at 11:12

        //better :
        var f5 = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
        System.out.println(f5.format(dt)); //October 20, 2022 at 11:12

        //Display sing quote :
        var f6 = DateTimeFormatter.ofPattern("MMMM dd', Party''s at' hh:mm");
        System.out.println(f6.format(dt2)); //October 20, Party's at 06:15

        var f7 = DateTimeFormatter.ofPattern("'System format, hh:mm: 'hh:mm");
        System.out.println(f7.format(dt2)); //System format, hh:mm: 06:15

        var f8 = DateTimeFormatter.ofPattern("'NEW! 'yyyy', yay!'");
        System.out.println(f8.format(dt2)); //NEW! 2022, yay!
    }
}