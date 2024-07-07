package certification.chapter4;

public class Part2 {

    public static void main(String[] args) {

        var name = "animals";
        System.out.println(name.length()); //7

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(name.charAt(0)); //a
        System.out.println(name.charAt(6)); //s
        System.out.println(name.charAt(7)); //StringIndexOutOfBoundsException

        System.out.println("-----------------------------------------------------------------------------------------");

        //indexOf : 4 methods
        System.out.println(name.indexOf('a')); //0
        System.out.println(name.indexOf("al")); //4
        System.out.println(name.indexOf('a', 3)); //4
        System.out.println(name.indexOf("al", 5)); //-1

        System.out.println("-----------------------------------------------------------------------------------------");

        //substring : zero-index based - optional second parameter endIndex
        System.out.println(name.substring(3)); //mals
        System.out.println(name.substring(name.indexOf('m'))); //mals
        System.out.println(name.substring(3,4)); //m
        System.out.println(name.substring(3, name.length())); //mals

        System.out.println(name.substring(3,3)); //empty string
        //System.out.println(name.substring(3, 2)); //StringIndexOutOfBoundsException
        //System.out.println(name.substring(3, 66)); //StringIndexOutOfBoundsException

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(name.toUpperCase()); //ANIMALS
        System.out.println("Abc123".toLowerCase()); //abc123

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("abc".equals("ABC")); //false
        System.out.println("ABC".equals("ABC")); //true
        System.out.println("abc".equalsIgnoreCase("ABC")); //true
        System.out.println("ABC".equalsIgnoreCase(null)); //false

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("abc".startsWith("a")); //true
        System.out.println("abc".startsWith("A")); //false
        System.out.println("abc".endsWith("c")); //true
        System.out.println("abc".endsWith("a")); //false

        System.out.println("abc".contains("b")); //true
        System.out.println("abc".contains("B")); //false

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("abcabc".replace('a', 'A')); //AbcAbc
        System.out.println("abcabc".replace("a", "A")); //AbcAbc
        System.out.println("abcabc".replace(new StringBuilder(""), "ZZ")); //ZZaZZbZZcZZaZZbZZcZZ

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("abc".strip()); //abc
        System.out.println("\t    a b c    \n".trim()); //a b c (strip does the same)

        String text = " abc\t ";
        System.out.println(text);
        System.out.println(text.trim().length()); //3
        System.out.println(text.strip().length()); //3
        System.out.println(text.stripLeading()); //abc ?? pq pas de tab ?
        System.out.println(text.stripLeading().length()); //5
        System.out.println(text.stripTrailing()); // abc
        System.out.println(text.stripTrailing().length()); //4

        System.out.println("-----------------------------------------------------------------------------------------");

        String dogName = "Jiro";
        System.out.println("*"+dogName.indent(2)+"*"); //*  Jiro + carriage return
        System.out.println("*"+dogName.indent(0)+"*"); //*Jiro + carriage return
        System.out.println("*"+("        " + dogName).indent(-2)+"*"); //*      Jiro + carriage return

        System.out.println("-----------------------------------------------------------------------------------------");

        var block = """
                    a
                     b
                    c""";

        var concat = " a\n"
                + "  b\n"
                + " c";

        System.out.println(block.length()); //6
        System.out.println(concat.length()); //9

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(block.indent(1).length()); //10 (6 + 3 + 1)
        System.out.println("*"+block.indent(1)+"*");

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(concat.indent(-1).length()); //7 (6+1)
        System.out.println("*"+concat.indent(-1)+"*");

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(concat.indent(-4).length()); //6
        System.out.println("*"+concat.indent(-4)+"*");

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(concat.stripIndent().length()); //6
        System.out.println(concat.stripIndent());


        System.out.println("-----------------------------------------------------------------------------------------");

        var str = "1\\t2";
        System.out.println(str); //1\t2
        System.out.println(str.length());
        System.out.println(str.translateEscapes()); //1   2 (tabulation)
        System.out.println("1\t2"); //1   2 (tabulation)

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(" ".isEmpty()); //false
        System.out.println("".isEmpty()); //true
        System.out.println("  ".isBlank()); //true
        System.out.println("".isBlank()); //true

        System.out.println("-----------------------------------------------------------------------------------------");

        var kateName = "Kate";
        var orderId = 5;
        System.out.println("Hello " + kateName+", order " + orderId + " is ready");
        System.out.println(String.format("Hello %s, order %d is ready", kateName, orderId));
        System.out.println("Hello %s, order %d is ready".formatted(kateName, orderId));

        System.out.println("-----------------------------------------------------------------------------------------");

        var jamesName = "James";
        var score = 90.25;
        var total = 100;
        System.out.println("%s:%n   Score: %f out of %d".formatted(jamesName, score, total));

        //var badStr = "Food: %d tons".formatted(2.0); //IllegalFormatConversionException

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("AniMaL     ".trim().toLowerCase().replace('a', 'A')); //AnimAl

        String a = "abc";
        String b = a.toUpperCase();
        b = b.replace("B", "2").replace('C', '3');
        System.out.println("a="+a); //a=abc
        System.out.println("b="+b); //b=A23
    }
}
