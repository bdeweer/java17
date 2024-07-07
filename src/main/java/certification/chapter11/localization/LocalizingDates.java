package certification.chapter11.localization;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalizingDates {

    public static void main(String[] args) {

        Locale.setDefault(new Locale("en", "US"));
        var italy = new Locale("it", "IT");

        var dt = LocalDateTime.of(2022, Month.OCTOBER, 20, 15, 12, 34);

        print(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT), dt, italy); //Can be : SHORT, MEDIUM, LONG, FULL
        print(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT), dt, italy);
        print(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT), dt, italy);

        System.out.println();

        print(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM), dt, italy); //Can be : SHORT, MEDIUM, LONG, FULL
        print(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM), dt, italy);
        print(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM), dt, italy);

        System.out.println();

        print(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG), dt, italy); //Can be : SHORT, MEDIUM, LONG, FULL
        print(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG), dt, italy);
        print(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG), dt, italy);

        System.out.println();

        print(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL), dt, italy); //Can be : SHORT, MEDIUM, LONG, FULL
        print(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL), dt, italy);
        print(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL), dt, italy);

        System.out.println();
    }

    public static void print(DateTimeFormatter dtf, LocalDateTime dateTime, Locale locale){

        System.out.println(dtf.format(dateTime) + " --- " + dtf.withLocale(locale).format(dateTime));
    }
}
