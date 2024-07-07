package certification.chapter14.part9;

import java.io.Console;
import java.util.Locale;

public class Test {

    public static void main(String[] args) {

        Console console = System.console();
        if(console != null){
            console.writer().println("Welcome to our zoo!");
            console.format("It has %d animals and employs %d people", 391, 25);
            console.writer().println();
            console.printf("The zoo spans %5.1f acres", 128.91);

            //use Locale with Console :
            console.writer().format(Locale.FRENCH, "toto %d", 55);
        }else {
            System.err.println("Console is not available");
        }
    }
}