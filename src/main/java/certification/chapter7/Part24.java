package certification.chapter7;

public class Part24 {
}

sealed class Penguin permits Emperor {}

//final class Emperor {} does not compile - must directly extends Penguin
final class Emperor extends Penguin{}