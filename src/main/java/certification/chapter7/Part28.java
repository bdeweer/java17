package certification.chapter7;

public class Part28 {
}

//sealed class Snake2 permits Cobra {}
sealed class Snake2 {} //permits class not required because Cobra is a top level class in the same file (this rules also applied to sealed classes with nested subclasses)

non-sealed class Cobra extends Snake2 {} //extends still required
