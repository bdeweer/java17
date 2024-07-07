package certification.chapter7;

public class Part25 {
}

sealed class Antelope permits Gazelle {}

final class Gazelle extends Antelope {}

//class George extends Gazelle {} does not compile