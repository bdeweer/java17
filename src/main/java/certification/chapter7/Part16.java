package certification.chapter7;

public class Part16 {
}

interface ZooTrainTour {
    abstract int getTrainName();
    static void ride(){}
    private static void privateRide(){}
    default void playHorn(){getTrainName(); ride();}
    public static void slowDown(){
        //playHorn(); //cannot be referenced by a static context
    }
    static void speedUp(){
        ride();
        ZooTrainTour.ride();
    }
}
