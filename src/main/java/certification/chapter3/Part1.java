package certification.chapter3;

public class Part1 {

    public static void main(String[] args) {

        int hourOfDay = 16;

        if(hourOfDay<11)
            System.out.println("Good Morning");
        else if(hourOfDay<15)
            System.out.println("Good Afternoon");
        else
            System.out.println("Good Evening");
    }
}
