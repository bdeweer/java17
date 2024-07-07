package certification.chapter7;

public class Part26 {
}

sealed class Mammal permits Equine {}

sealed class Equine extends Mammal permits Zebra {} //same rules as Mammal

final class Zebra extends Equine {} //Zebra is an indirect subclass of Mammal but not listed in Mammal