package certification.chapter6;


import java.util.LinkedList;

public class Tricks {

}

class Bird2 {
    int feathers = 0;
    Bird2(int x){
        this.feathers = x;
    }
    Bird2 fly(){
        return new Bird2(1);
    }
}

class Parrot extends Bird2{

    protected  Parrot(int x) {
        super(x);
    }
    protected Parrot fly(){
        return new Parrot(2);
    }
}

class Macaw extends Parrot {

    public Macaw(int x) {
        super(x);
    }

    public Macaw fly(){
        return new Macaw(3);
    }

    public static void main(String[] args) {
        Bird2 p = new Macaw(4);
        System.out.println(p.fly()); //au runtime c'est un Macaw => feathers = 3
        System.out.println(((Parrot)p.fly()).feathers); //Le cast Parrot est juste la pour nous troubler
    }
}

abstract class Whale2 {
    public abstract void dive(int ... i);

    public static void main(String[] args) {
        Whale2 whale2 = new Orca();
        whale2.dive(3);
    }
}

class Orca extends Whale2 {
    static public int MAX = 3;
    public void dive(){
        System.out.println("Orca diving");
    }
    public void dive(int ... depth){
        System.out.println("Orca diving deeper " + MAX);
    }
}


class Person {
    static String name;
    void setName(String q){
        System.out.println("jamais");
        name = q;
    }
}

class Child extends Person {
    static String name; //hiding (two distinct variables exists)
    void setName(String w){
        name = w;
    }

    public static void main(String[] args) {
        final Child m = new Child();
        final Person t = m;
        m.name = "Elysia";
        t.name = "Sophia";
        m.setName("Webby");
        t.setName("Olivia"); //override at runtime
        System.out.println(m.name + "  " + t.name);
    }
}

class Canine2 {
    public Canine2(boolean t){
        logger.append("a");
    }

    public Canine2(){
        logger.append("q");
    }

    private StringBuilder logger = new StringBuilder();
    protected void print(String v){
        logger.append(v);
    }

    protected String view() {
        return logger.toString();
    }
}

class Fox2 extends Canine2 {
    public Fox2(long x){
        print("p");
    }
    public Fox2(String name){
        this(2);
        print("z");
    }
}

class Fennec extends Fox2 {
    public Fennec(int e){
        super("tails");
        print("j");
    }
    public Fennec(short f){
        super("eeve");
        print("m");
    }

    public static void main(String[] args) {
        System.out.println(new Fennec(1).view());
    }
}

class Antelope {
    public Antelope(int p){
        System.out.println("4");
    }
    {
        System.out.println("2");
    }
    static {
        System.out.println("1");
    }
}

class Gazelle extends Antelope {
    public Gazelle(int p){
        super(6);
        System.out.println("3");
    }

    public static void main(String[] args) {
        new Gazelle(10);
    }
    static {
        System.out.println("8");
    }
    {
        System.out.println("9");
    }
}

class PolarBear {
    StringBuilder value = new StringBuilder("t");
    {value.append("a");}
    {value.append("c");}
    private PolarBear(){
        value.append("b");
    }
    public PolarBear(String s){
        this();
        value.append(s);
    }

    public PolarBear(CharSequence p){
        value.append(p);
    }

    public static void main(String[] args) {
        Object bear = new PolarBear();
        bear = new PolarBear("f");
        System.out.println(((PolarBear)bear).value);
    }
}

class Mammal4 {
    private void eat(){}
    protected static void drink(){}
    public Integer dance(String p){
        return null;
    }
}

class Primate2 extends Mammal4 {
    public void eat(String p){}

}

class Monkey extends Primate2 {
    public static void drink() throws RuntimeException {}

    public Number dance(CharSequence p){
        return null;
    }

    /*public int eat(String p){
        return 2;
    }*/
}

class Reptile3 {
    {
        System.out.println("A");
    }
    public Reptile3(int hatch){}

    void layEggs(){
        System.out.println("Reptile");
    }
}

class Lizard extends Reptile3 {
    static {
        System.out.println("B");
    }
    public Lizard(int hatch){
        super(hatch);
    }
    public final void layEggs(){
        System.out.println("Lizard");
    }

    public static void main(String[] args) {
        var reptile = new Lizard(1);
        reptile.layEggs();
    }

}