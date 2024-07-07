package tests.chapter11;

import java.text.NumberFormat;
import java.util.Locale;

public class StudyTest {

    public static void main(String[] args) {

        double t = 100_102.2;
        Locale.setDefault(Locale.US);
        System.out.println(NumberFormat.getCompactNumberInstance().format(t));
        System.out.println(NumberFormat.getCurrencyInstance().format(t));
    }
}
