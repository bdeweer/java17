package certification.chapter5.modifiers.pond.inland;

import certification.chapter5.modifiers.pond.shore.Bird;

public class BirdWatcherFromAfar {

    public void watchBird(){
        Bird bird = new Bird(); //not in the same package
        //bird.floatInWater();
        //System.out.println(bird.text);
    }
}
