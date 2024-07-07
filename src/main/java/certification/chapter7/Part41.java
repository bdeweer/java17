package certification.chapter7;

public class Part41 {


}

class Park {

    public static void main(String[] args) {

        var ride = new Ride();
        System.out.println(ride.price);
        // System.out.println(Ride.price); //does not compile

    }

    static class Ride {
        private int price = 6;
    }
}