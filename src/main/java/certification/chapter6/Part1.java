package certification.chapter6;

public class Part1 {

}

class BigCat {
    protected double size;
}

class Jaguar extends BigCat {

    public Jaguar() {
        this.size = 10.2; //can read or write size as if it were on its own member
    }

    public void printDetails(){
        System.out.println(size);
    }
}

class Spider {
    public void printDetails(){
        //System.out.println(size); does not compile
    }
}