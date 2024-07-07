package certification.chapter11.localization;

import java.text.NumberFormat;
import java.util.Locale;

public class LocalizingNumbers {

    public static void main(String[] args) {

        var nf1 = NumberFormat.getInstance();
        var nf2 = NumberFormat.getNumberInstance();
        var nf3 = NumberFormat.getCurrencyInstance();
        var nf4 = NumberFormat.getPercentInstance();
        var nf5 = NumberFormat.getIntegerInstance();
        var nf6 = NumberFormat.getCompactNumberInstance();

        //Number
        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;

        System.out.println(attendeesPerMonth); //266666

        var us = NumberFormat.getInstance(Locale.US);
        System.out.println(us.format(attendeesPerMonth)); //266,666

        var gr = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println(gr.format(attendeesPerMonth)); //266.666

        var ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(ca.format(attendeesPerMonth)); //266 666

        //currency
        double price = 48;
        var myLocale = NumberFormat.getCurrencyInstance();
        System.out.println(myLocale.format(price)); //48,00 €

        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(price)); //$48.00

        //percentage
        double successRate = 0.802;

        var usP = NumberFormat.getPercentInstance(Locale.US);
        System.out.println(usP.format(successRate)); //80%

        var grP = NumberFormat.getPercentInstance(Locale.GERMANY);
        System.out.println(grP.format(successRate)); //80 %
    }
}