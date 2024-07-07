package certification.chapter7;

public class Part9 {
}


abstract class Husky {
    abstract void play(); //must be marked abstract
}

class Webby extends Husky {
    void play(){} //ok - play() is declared with package access in Husky
}

abstract interface Poodle {
    void play(); //implicit public abstract
}

class Georgette implements Poodle {
    //void play(){} //does not compile because play is public
    public void play(){}
}
