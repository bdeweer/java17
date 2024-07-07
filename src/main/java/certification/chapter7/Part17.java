package certification.chapter7;

public class Part17 {

    public static void main(String[] args) {

        var s = Season.SUMMER;
        System.out.println(Season.SUMMER); //SUMMER
        System.out.println(s == Season.SUMMER); //true
        System.out.println(s.name()); //SUMMER
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("");

        for(var season : Season.values()){
            System.out.println(season.name() + " " + season.ordinal());
        }
        //if(Season.SUMMER = 2){} //does not compile
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("");
        Season summer = Season.valueOf("SUMMER"); //must match the value exactly
        //Season fall = Season.valueOf("Fall"); //IllegalArgumentException

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("");

        switch (summer){
            //case Season.WINTER: does not compile
            //case 0 : does not compile
            case WINTER: //type is implicit
                System.out.println("Get out the sled!");
                break;
            case SUMMER:
                System.out.println("Time for the pool!");
                break;
            default:
                System.out.println("Is it summer yet ?");
        }

    }
}


enum Season {
    WINTER, SPRING, SUMMER, FALL; //Optional semicolon
}