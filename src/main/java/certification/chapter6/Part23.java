package certification.chapter6;

public class Part23 {
}

class Bird {
    public final boolean hasFeathers(){
        return true;
    }
    public final static void flyAnyway(){}
}

class Penguin extends Bird {

    //public final boolean hasFeathers(){} //does not compile
    //public final static void flyAnyway(){} //does not compile
}