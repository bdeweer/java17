package certification.chapter7;

public class Part27 {
}

sealed class Wolf2 permits Timber2 {} //Wolf2 is still sealed !

non-sealed class Timber2 extends Wolf2 {} //open a sealed parent class to potentially unknown subclasses.

class MyWolf extends Timber2 {} //Can be extended

class MyFurryWolf extends MyWolf {}