package certification.chapter4;

public class Part1 {

    public static void main(String[] args) {

        String blue;

        System.out.println("test");

        String name = """
                      Fluffy""";

        System.out.println(name);

        System.out.println(1 +2); //3
        System.out.println("a" + "b"); //ab
        System.out.println("a" + "b" + 3); //ab3
        System.out.println(1+2+"c"); //3c
        System.out.println("c" + 1 + 2); //c12
        System.out.println("c"+null); //cnull
        System.out.println(null + "c"); //nullc
        //System.out.println(null); //does not compile

        int three = 3;
        String four = "4";
        System.out.println(1+2+three+four); //64

        var s = "1";
        s += 2;
        s += 3;
        System.out.println(s); //123
    }
}
