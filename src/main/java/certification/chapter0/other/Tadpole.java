package certification.chapter0.other;

import certification.chapter0.animal.Frog;

public class Tadpole extends Frog {

    {
        ribbit();
    }

    public static void main(String[] args) {

        Tadpole t = new Tadpole();
        t.ribbit();
        //t.jump();

        Frog f = new Tadpole();
        //f.ribbit();

    }
}
