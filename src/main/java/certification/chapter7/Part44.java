package certification.chapter7;

public class Part44 {
}


class Primate {
    public boolean hasHair(){
        return true;
    }
}

interface HasTail2 {
    public abstract boolean isTailStriped();
}

class Lemur extends Primate implements HasTail2{

    @Override
    public boolean isTailStriped() {
        return false;
    }

    public int age = 10;

    public static void main(String[] args) {

        Lemur lemur = new Lemur();
        System.out.println(lemur.age); //10
        System.out.println(lemur.isTailStriped()); //false
        System.out.println(lemur.hasHair()); //true
        System.out.println("-----------------------------------------------------------");

        HasTail2 hasTail2 = lemur;
        System.out.println(hasTail2.isTailStriped()); //false
        //System.out.println(hasTail2.age); //does not compile
        //System.out.println(hasTail2.hasHair()); //does not compile

        System.out.println("-----------------------------------------------------------");

        Primate primate = lemur;
        System.out.println(primate.hasHair()); //true
        //System.out.println(primate.age); //does not compile
        //System.out.println(primate.isTailStriped()); //does not compile

        Lemur lemur1 = new Lemur();
        Primate primate1 = lemur1;

        Lemur lemur2 = (Lemur)primate1;

        //Lemur lemur3 = primate1; does not compile
    }
}