package certification.chapter5.modifiers.pond.shore;

public class BirdWatcher {

    public void watchBird(){
        Bird bird = new Bird(); //same package
        bird.floatInWater();
        System.out.println(bird.text);
    }
}
