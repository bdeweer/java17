package certification.chapter7;

public class Part23 {
}

//sealed class Bear2 {} //does not compile (Sealed class must have subclasses) - It compiles because same file (permits clause can be omitted)

sealed class Bear2 permits Kodiak, Panda{}

final class Kodiak extends Bear2{}

non-sealed class Panda extends Bear2{}


//class sealed Frog permits GlossFrog {} //class and sealed modifiers are in the wrong order

sealed class Frog permits GlassFrog {}

sealed class GlassFrog extends Frog permits Wolf{}
//class GlossFrog extends Frog {} must be non-sealed or final

abstract sealed class Wolf extends GlassFrog permits Timber{}

final class Timber extends Wolf {}
//final class MyWolf extends Wolf {} //MyWolf isn't listed in the declaration of Wolf