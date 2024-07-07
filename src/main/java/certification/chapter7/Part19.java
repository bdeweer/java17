package certification.chapter7;

public class Part19 {

    public static void main(String[] args) {

        //constructing is printed only once!
        System.out.println("begin,");
        OnlyOne firstCall = OnlyOne.ONCE;
        OnlyOne secondCall = OnlyOne.ONCE;
        System.out.println("end");

    }
}


enum OnlyOne{
    ONCE(true);

    private OnlyOne(boolean b){
        System.out.println("constructing,");
    }
}