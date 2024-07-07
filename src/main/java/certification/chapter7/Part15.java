package certification.chapter7;

public class Part15 {

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.printStatus();
    }

    interface ZooRenovation {

        public String projectName();
        abstract String status();
        default void printStatus(){
            System.out.println("The " + projectName() + " project is " + status());
        }
    }

    static class Zoo implements ZooRenovation{


        @Override
        public String projectName() {
            return "certification";
        }

        @Override
        public String status() {
            return "in progress";
        }
    }
}