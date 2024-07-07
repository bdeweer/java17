package certification.chapter5;

public class Part4 {
}

class Snake {
    public static long hiss = 2;
    public final int size; //does not compile

    {
        size = 3;
    }

    public static void main(String[] args) {

        System.out.println(hiss);
        System.out.println(Snake.hiss);
        Snake s = new Snake();
        System.out.println(s.hiss); //2
        s = null;
        System.out.println(s.hiss); //2
    }
}



