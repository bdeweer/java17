package certification.chapter3;

public class Part5 {

    public static void main(String[] args) {


    }

    public void printDayOfWeek(int day){
        var result = switch(day){

            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid value";
        }; //very important ;

        System.out.println(result);
    }

    public void printSeason(int month){
        switch(month){
            case 1,2,3 -> System.out.println("Winter");
            case 4,5,6 -> System.out.println("Spring");
            case 7,8,9 -> System.out.println("Summer");
            case 10,11,12 -> System.out.println("Fall");
            //default is optional (no return value)
         }
    }

    public void printSeason2(int month){

        System.out.println(
                switch (month){
                    case 1,2,3 -> "Winter";
                    case 4,5,6 -> "Spring";
                    case 7,8,9 -> "Summer";
                    case 10,11,12 -> "Fall";
                    default -> "Invalid value";
                }
        );
    }


    public void measurement(){

        int measurement = 10;
        int size = switch(measurement){
            case 5 -> 1;
            case 10 -> (short)2;
            default -> 5;
            //case 20 -> "3"; //does not compile
            //case 40 -> 4L; //does not compile
            //case 50 -> null; //does not compile
        };
    }

    public void yield(){
        int fish = 5;
        int length = 12;
        var name = switch (fish){
            case 1 -> "Goldfish";
            case 2 -> {
                yield "Green"; //yield, not return!
            }
            case 3 -> {
                if(length>10) yield "Blobfish";
                else yield "Green";
            }//; extra semi colon (does not compile)
            default -> "Swordfish";
        };
    }

    public void allPossibleValues(int canis){
        String type = switch(canis){
            case 1 -> "dog";
            case 2 -> "wolf";
            case 3 -> "coyote";
            default -> "default"; //mandatory default statement
        };
    }

    enum Season {WINTER, SPRING, SUMMER, FALL}

    public String enumSwitchExpression(Season value){
        return switch(value){
            case WINTER -> "winter";
            case SPRING -> "Spring";
            case SUMMER -> "Summer";
            case FALL -> "Fall";
            //default not required (but good practice)
        };
    }
}


