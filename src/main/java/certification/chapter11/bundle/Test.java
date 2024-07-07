package certification.chapter11.bundle;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

    public static void main(String[] args) {

        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        //Locale englishCanada = new Locale("en", "CA");
        //Locale frenchCanada = new Locale("fr", "CA");

        printWelcomeMessage(us);
        System.out.println("---------------------------------");
        printWelcomeMessage(france);

    }

    public static void printWelcomeMessage(Locale locale){
        var rb = ResourceBundle.getBundle("Zoo", locale);

        rb
                .keySet()
                .stream()
                .map(k -> k + " : " + rb.getString(k))
                .forEach(System.out::println);
        //System.out.println(rb.getString("hello") + " - " + rb.getString("open"));

        System.out.println();
        String format = rb.getString("helloByName");
        System.out.println(MessageFormat.format(format, "Jiro", "Croco"));
    }
}