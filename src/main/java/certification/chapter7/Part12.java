package certification.chapter7;

public class Part12 {
}

interface Walk {
    public default int getSpeed(){return 5;}
}

interface Run {
    public default int getSpeed(){return 10;}
}

//class Cat implements Walk, Run {} //does not compile

class Cat implements Walk, Run {

    @Override
    public int getSpeed() {
        //return Walk.super.getSpeed(); //Call the Wak method
        //return Run.super.getSpeed(); //Call the Wak method

        //return Walk.getSpeed(); //does not compile
        //return Run.getSpeed(); //does not compile


        return 1;
    }

    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.getSpeed();


    }
}