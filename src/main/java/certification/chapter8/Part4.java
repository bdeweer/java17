package certification.chapter8;

import java.io.Console;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class Part4 {
}

interface LearnToSpeak {
    void speak(String sound);
}

class DuckHelper {
    public static void teacher(String name, LearnToSpeak trainer){
        trainer.speak(name);
    }
}

class Duckling {
    public static void makeSound(String sound){
        //LearnToSpeak learner = s -> System.out.println(s);
        LearnToSpeak learner = System.out::println;
        Consumer<String> c = System.out::println;
        LearnToSpeak learn2 = s -> Logger.getAnonymousLogger().config(s);
        DuckHelper.teacher(sound, learner);
    }
}