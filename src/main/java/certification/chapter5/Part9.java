package certification.chapter5;

public class Part9 {

    public static void main(String[] args) {

        int quack = 5;
        Integer quackquack = Integer.valueOf(5);

        int quackquackquack = quackquack.intValue();

        int squirt = 5;
        Integer squirtsquirt = squirt; //autoboxing
        int squirtsquirtsquirt = squirtsquirt; //unboxing

        Short tail = 8;
        Character p = Character.valueOf('p');
        char paw = p ; //unboxing

        Boolean nose = true; //autoboxing
        Integer e = Integer.valueOf(9);
        long ears = e; //unboxing, then implicit casting

        //Long badGorilla = 8; //Impossible to cast and autoboxing at the same time

        Long badGorilla = 8L;

        Character elephant = null;
        char badElephant = elephant; //NullPointerException (Java tries to get the char value of null)
    }
}
