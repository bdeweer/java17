package tests.chapter3;

public sealed class Fish {
    final class Blobfish extends Clownfish{}
    private non-sealed class Dory extends Bluetang{}
    sealed class Clownfish extends Fish{}
    sealed class Bluetang extends Fish {}
    final class Swordfish extends Fish {}
    private non-sealed class Nemo extends Clownfish {}
}

non-sealed class XXX extends Fish {}
