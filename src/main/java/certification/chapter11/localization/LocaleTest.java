package certification.chapter11.localization;

import java.util.Locale;

public class LocaleTest {

    public static void main(String[] args) {

        Locale locale = Locale.getDefault();
        System.out.println(locale); //language_country => fr_FR

        System.out.println(new Locale("fr_FR"));
        System.out.println(new Locale("EN")); //invalid

        System.out.println(Locale.GERMAN); //de
        System.out.println(Locale.GERMANY); //de_DE

        //By builder
        Locale locale1 =
                new
                        Locale
                                .Builder()
                        .setLanguage("en")
                        .setRegion("US")
                        .build()
                ;
    }
}