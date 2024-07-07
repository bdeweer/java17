package certification.chapter7;

public class Part38 {

    public static void main(String[] args) {
        Home home = new Home();
        home.enterRoom();
        System.out.println("-----------------------------------------------------------------------------------------");
        Home.Room room = home.new Room();
        room.enter();
        System.out.println("-----------------------------------------------------------------------------------------");
        new Home().new Room().enter();

    }
}


class Home {

    private String greeting = "Hi";

    protected class Room {

        public int repeat = 3;
        public void enter() {
            for (int i = 0; i < repeat; i++) {
                greet(greeting);
            }
        }

        private static void greet(String message){
            System.out.println(message);
        }
    }

    public void enterRoom(){
        var room = new Room();
        room.enter();
    }
}