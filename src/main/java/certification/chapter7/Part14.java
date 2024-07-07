package certification.chapter7;

public class Part14 {
}

interface Schedule{

    default void wakeUp(){
        checkTime(7); //can access static method
    }

    private void haveBreakfast(){
        checkTime(9); //Can access static method
    }

    static void workOut(){
        checkTime(18);
    }

    private static void checkTime(int hour){
        if(hour > 17){
            System.out.println("You're late!");
        }
        else {
            System.out.println("You have " + (17-hour) + " hours left to make the appointment");
        }
    }
}