package certification.chapter3;

public class Part4 {

    public static void main(String[] args) {

    }

    void feedAnimals(){
        final int bananas = 1; //Compile time constant
        int apples = 2; //not marked final
        int numberOfAnimals = 3;
        final int cookies = getCookies(); //value is evaluated at runtime
        switch (numberOfAnimals){
            case bananas :
            //case apples : //does not compile
            //case cookies: //does not compile
            //case getCookies(): //does not compile
            case 3 * 5: //expression are allowed as case values
        }
    }

    final int getCookies(){
        return 4;
    }
}
