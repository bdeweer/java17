package certification.chapter6;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Part18 {
}

class Marsupial {
    public double getAverageWeight(){
        return 50;
    }
}

class Kangaroo extends Marsupial {
    public double getAverageWeight(){
        //return getAverageWeight() + 20; //StackOverFlow error
        return super.getAverageWeight() + 20;
    }

    public static void main(String[] args) {
        System.out.println(new Marsupial().getAverageWeight()); //50.0
        System.out.println(new Kangaroo().getAverageWeight()); //70.0
    }
}


class Reptile2 {

    protected void sleep() throws IOException {}

    protected void hide(){}

    protected void exitShell() throws FileNotFoundException {}
}

class GalapagosTortoise extends Reptile2{
    public void sleep() throws FileNotFoundException {}

    //public void hide() throws IOException {} //does not compile

    //public void exitShell() throws IOException {} //does not compile
}


class Rhino2 {
    protected CharSequence getName(){
        return "rhino";
    }
    protected String getColor(){
        return "grey, black, or white";
    }
}

class JavanRhino extends Rhino2 {
    @Override
    public String getName(){
        return "javan rhino";
    }

    //does not compile
    //public CharSequence getColor(){
      //  return "grey";
    //}
}

