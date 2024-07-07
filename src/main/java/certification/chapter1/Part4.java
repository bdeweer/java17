package certification.chapter1;

public class Part4 {

    public static void main(String[] args) {

        String eyeTest = "\"Java Study Guide\" \n  by Scott & Jeanne";

        System.out.println(eyeTest);
        System.out.println();

        String pyramid = """
                  *
                 * *
                * * * 
                """; //new line without any characters
        System.out.println(pyramid); //4 lines output

        System.out.println();

        //String block = """not good"""; //does not compile

        System.out.println("ici");
        String block = """
                doe \
                deer""";

        System.out.println(block); //only one line

        System.out.println("------------------------------------------------------");

        String block2 = """
                doe \n
                deer
                """;

        System.out.println(block2); //prints 4 lines

        System.out.println("----------------------------------------------------------");

        String block3 = """
                "doe\"\"\"
                \"deer\"""
                """;

        System.out.println("*" + block3 + "*"); //one space of essential white space

        System.out.println("---------------------------------------------");

        var blocky = """
                squirrel \s
                pigeon   \
                termite""";

        System.out.println(blocky);
        System.out.println("fini");
    }
}
