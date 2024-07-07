package certification.chapter6;

public class Part21 {

}

class Bear2 {
    public static void sneeze(){
        System.out.println("Bear is sneezing");
    }
    public void hibernate(){
        System.out.println("Bear is hibernating");
    }
    public static void laugh(){
        System.out.println("Bear is laughing");
    }
}

class SunBear extends Bear2 {
    //public void sneeze(){} //does not compile
    //public static void hibernate(){} //does not compile
    //protected static void laugh(){} //does not compile (more restrictive)
}
