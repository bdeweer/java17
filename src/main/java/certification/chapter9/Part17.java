package certification.chapter9;

import java.util.ArrayList;
import java.util.List;

public class Part17 {


}

class Mammal {
    public List<CharSequence> play(){
        return null;
    }

    public CharSequence sleep() {
        return null;
    }
}

class Monkey extends Mammal {
    public ArrayList<CharSequence> play() {
        return null;
    }
}

class Goat extends Mammal {

    //public List<String> play(){} does not compile

    public String sleep(){ //covariant return type
        return null;
    }
}
