package certification.chapter11.localization;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleCategory {

    public static void main(String[] args) {

        var spain = new Locale("es", "ES");
        var money = 1.23;

        Locale.setDefault(new Locale("en", "US"));
        printCurrency(spain, money);

        Locale.setDefault(Locale.Category.DISPLAY, spain);
        printCurrency(spain, money);

        Locale.setDefault(Locale.Category.FORMAT, spain);
        printCurrency(spain, money);
    }

    public static void printCurrency(Locale locale, double money){
        System.out.println(
                NumberFormat.getCurrencyInstance().format(money)
                +
                ", "
                +
                locale.getDisplayLanguage()
        );
    }
}
