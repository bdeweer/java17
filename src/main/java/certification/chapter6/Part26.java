package certification.chapter6;

public class Part26 {
}

abstract class Animal5 {
    abstract String getName();
}

abstract class BigCat2 extends Animal5 {
    protected abstract void roar();
}

class Lion2 extends BigCat2 {

    public String getName(){
        return "Lion";
    }

    public void roar(){
        System.out.println("The lion lets out a loud ROAR!");
    }
}
