package certification.chapter5;

public class Part8 {
}

class ZooTickets {

    public static void main(String[] args) {
        int tickets = 2 ;
        String guests = "abc";
        addTickets(tickets);
        guests = addGuests(guests);
        System.out.println(tickets + guests); //2abcd
    }

    public static int addTickets(int tickets){
        tickets++;
        return tickets;
    }

    public static String addGuests(String guests){
        guests += "d";
        return guests;
    }
}
