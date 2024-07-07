package certification.chapter5;

public class Trick {
}


class RopeSwing {

    private static Rope rope1 = new Rope();
    private static Rope rope2 = new Rope();

    {
        System.out.println(rope1.length);
    }

    public static void main(String[] args) {
        rope1.length = 2;
        rope2.length = 8;

        System.out.println(rope1.length);
    }

}

class Rope {
    public static int length = 0;
}


class Squares {
    public static long square(int x){
        var y = x * (long) x;
        x -= 1;
        return y;
    }

    public static void main(String[] args) {
        var value = 9;
        var result = square(9);
        System.out.println(value);
    }
}

class ClassRoom {
    private int roomNumber;
    protected static String teacherName;
    static int globalKey = 54321;
    public static int floor = 3;
    ClassRoom(int r, String t){
        roomNumber = r;
        teacherName = t;
    }
}

