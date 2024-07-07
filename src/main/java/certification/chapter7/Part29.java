package certification.chapter7;

public class Part29 {
}

sealed class Snake3 permits Snake3.Cobra{ //for nesting subclasses, we recommend omitting the permits class

    final class Cobra extends Snake3 {}
}