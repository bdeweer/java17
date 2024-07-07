package certification.chapter6;

public class Part22 {
}

class Carnivore {
    protected boolean hasFur = false;
}

class Meerkat extends Carnivore {
    protected boolean hasFur = true;

    public static void main(String[] args) {

        Meerkat meerkat = new Meerkat();
        Carnivore c = meerkat;
        System.out.println(meerkat.hasFur); //true
        System.out.println(c.hasFur); //false
    }
}