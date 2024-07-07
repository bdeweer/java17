package certification.chapter11.localization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.stream.Stream;

public class ParsingNumbers {

    public static void main(String[] args) throws ParseException {

        String s = "40.45";

        var en = NumberFormat.getInstance(Locale.US);
        System.out.println(en.parse(s)); //40.45

        var fr = NumberFormat.getInstance(Locale.FRANCE);
        System.out.println(fr.parse(s)); //40 (. is not part of a number in France)

        String p = "40,45";
        var en2 = NumberFormat.getInstance(Locale.US);
        System.out.println(en2.parse(p)); //4045

        var fr2 = NumberFormat.getInstance(Locale.FRANCE);
        System.out.println(fr2.parse(p)); //40,45

        System.out.println();

        //Parsing currency
        String income = "$92,807.99";
        var cf = NumberFormat.getCurrencyInstance(Locale.US);
        //var cf = NumberFormat.getCurrencyInstance(Locale.FRANCE); //java.text.ParseException
        double value = (Double)cf.parse(income); //Number is the parent class of all java.lang wrapper
        System.out.println(value); //92807.99
        System.out.println(cf.parse(income)); //92807.99

        System.out.println();

        //CompactNumberFormat
        var formatters1 = Stream.of(
                NumberFormat.getCompactNumberInstance(), //short is used by default
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.SHORT),
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.LONG),
                NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.SHORT),
                NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.LONG),
                NumberFormat.getNumberInstance()
        );

        formatters1.map(ss -> ss.format(7_123_456)).forEach(System.out::println);

        System.out.println();

        var formatters2 = Stream.of(
                NumberFormat.getCompactNumberInstance(), //short is used by default
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.SHORT),
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.LONG),
                NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.SHORT),
                NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.LONG),
                NumberFormat.getNumberInstance()
        );

        formatters2.map(ss -> ss.format(314_900_000)).forEach(System.out::println);
    }
}