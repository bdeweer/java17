package certification.chapter1;

public class Tricks {

    public static void main(String[] args) {

        //var day = 1/0;

        System.out.println("test\saa");
        System.out.println("""
                aa\sddd     \
                pp""");

        var blocky = """
                squirrel \s
                pigeon   \
                termite""";

        System.out.println(blocky);
        System.out.println("end");
    }
}

class KitchenSink {

    private int numForks;
    public static float code;

    public static void main(String[] args) {

        System.out.println("""
                "# forks = " + numForks +
                 " # knives = " + numKnives +
                # cups = 0""");
        System.out.println("---------");

        var magic = 3_13.0;

        System.out.println(code);
    }
}

class PoliceBox {
    String color;
    long age;
    public PoliceBox(){
        color="blue";
        age = 1200;
    }

    public static void main(String[] args) {
        var p = new PoliceBox();
        var q = new PoliceBox();
        p.color="green";
        p.age=1400;
         p = q;
        System.out.println(q.color);
        System.out.println(q.age);
        System.out.println(p.color);
        System.out.println(p.age);
    }
}

class TestPart1 {

    {
        name = "Test";
        num1 = -44.44D;
        num2 = -55.55F;
    }

    private String name;
    private double num1;
    private float num2;
    private String _Q2s;

}