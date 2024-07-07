package certification.chapter4;

public class Test4 {

    public static void main(String[] args) {

        var base = "ewe\nsheep\\t";

        int length = base.length();

        int indent = base.indent(2).length();
        System.out.println(base.indent(2));
        int translate = base.translateEscapes().length();

        System.out.println(length);
        System.out.println(indent);
        System.out.println(translate);
    }
}
