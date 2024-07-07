package certification.chapter3;

public class Part3 {

    public static void main(String[] args) {

        short animal = 1;
        final int i = 100000;
        final int j = 10000;

        //case can be combined
        switch(animal){
            case 1,2 :
                System.out.println("Lion");
            case 3:
                System.out.println("Tiger");
        }

        //prior to Java 14
        switch(animal){
            case 1 :
            case 2:
                System.out.println("Lion");
            case 3:
                System.out.println("Tiger");
            //case i: //does not compile
                // System.out.println("ko");
            case j: //j is int!
                System.out.println("ok");
        }
    }
}
