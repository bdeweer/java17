package certification.chapter5.modifiers.pond.goose;

import certification.chapter5.modifiers.pond.shore.Bird;

public class Gosling extends Bird {

    public void swim(){
        floatInWater();
        System.out.println(text);
    }

    public static void main(String[] args) {
        new Gosling().swim();
    }
}
