package certification.chapter11.formatting;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormattingValues {

    public static void main(String[] args) {

        System.out.printf("Welcome to %s!%n", "Jiro");
        //System.out.printf("Welcome to %x!%n", "Jiro"); //IllegalFormatException

        System.out.println(Locale.getDefault());

        Locale.setDefault(new Locale("en", "US"));

        NumberFormat nf; //abstract class
        DecimalFormat dc; //concrete class

        double d = 1234.567;
        NumberFormat f1 = new DecimalFormat("###,###,###.0");
        System.out.println(f1.format(d)); //1,234.6 (rounding to the nearest)

        NumberFormat f2 = new DecimalFormat("000,000,000.00000");
        System.out.println(f2.format(d)); //000,001,234.56700

        NumberFormat f3 = new DecimalFormat("Your Balance $#,###,###.##");
        System.out.println(f3.format(d)); //Your Balance $1,234.57
    }
}