package certification.chapter4;

public class Part3 {

    public static void main(String[] args) {

        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        System.out.println(a == b);
        System.out.println(a.equals(b));
        b = b.append("f").append("g");
        System.out.println("a="+a); //abcdefg
        System.out.println("b="+b); //abcdefg

        System.out.println("-----------------------------------------------------------------------------------------");

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("Jiro");
        StringBuilder sb3 = new StringBuilder(10);

        System.out.println("-----------------------------------------------------------------------------------------");

        var sb = new StringBuilder("animals");
        System.out.println(sb.substring(1,1)); //print a blank line
        String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al")); //anim
        int len = sb.length(); //7
        var ch = sb.charAt((6)); //s
        System.out.println(sub + " " + len + " " + ch); //anim 7 s

        System.out.println("-----------------------------------------------------------------------------------------");
        var sb4 = new StringBuilder().append(1).append('c');
        sb4.append("-").append(true);
        System.out.println(sb4); //1c-true

        System.out.println("-----------------------------------------------------------------------------------------");
        var sb5 = new StringBuilder("animals");
        sb5.insert(7, "-");
        sb5.insert(0, "-");
        sb5.insert(4, "-");
        System.out.println(sb5); //-ani-mals-

        System.out.println("-----------------------------------------------------------------------------------------");

        var sb6 = new StringBuilder("abcdef");
        sb6.delete(1,3); //adef
        sb6.delete(1, 100); //a - If you specify a second parameter that is past the end of the StringBuilder, Java will assume you meant the end
        //sb6.deleteCharAt(9); //StringIndexOutOfBoundsException

        System.out.println("-----------------------------------------------------------------------------------------");

        var builder = new StringBuilder("pigeon dirty");
        builder.replace(3,6, "sty");
        System.out.println(builder); //pigsty dirty

        builder = new StringBuilder("pigeon dirty");
        builder.replace(3,100, "");
        System.out.println(builder); //pig

        System.out.println("-----------------------------------------------------------------------------------------");
        var sb7 = new StringBuilder("ABC");
        sb7.reverse();
        System.out.println(sb7); //CBA

    }
}
