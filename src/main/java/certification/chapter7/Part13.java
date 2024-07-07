package certification.chapter7;

public class Part13 {


}

interface Hop {

    static int getJumpHeight(){ //implicitly public
        return 8;
    } //implicit public
}

class Skip {
    public int skip(){
        return Hop.getJumpHeight();
    }
}

class Bunny implements Hop {


    public void printDetails(){
        //System.out.println(getJumpHeight()); //does not compile
        System.out.println(Hop.getJumpHeight());
    }
}