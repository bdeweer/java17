package certification.chapter7;

public class Part46 {
}

class Rodent {}

class Capybara extends Rodent {

    public static void main(String[] args) {

        Rodent rodent = new Rodent();
        //Rodent rodent = new Capybara(); //No ClassCastException
        var capybara = (Capybara) rodent; //ClassCastException

        if(rodent instanceof Capybara){
            //do stuff
        }
    }
}