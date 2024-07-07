package certification.chapter9;

public class Part19 {

    public static void main(String[] args) {

        TrickyCrate<Robot> crate = new TrickyCrate<>();
        System.out.println(crate.tricky("bot"));
    }

    public static <T> void prepare(T t){
        System.out.println("Preparing " + t);
    }

    public static <T> Crate<T> ship(T t){
        System.out.println("Shipping " + t);
        return new Crate<T>();
    }

    public static <T> void skink(T t){}

    public static <T> T identity(T t){
        return t;
    }

    //public static T noGood(T t ){return t;} //does not compile
}

class TrickyCrate<T>{
    public <T> T tricky(T t){
        return t;
    }
}