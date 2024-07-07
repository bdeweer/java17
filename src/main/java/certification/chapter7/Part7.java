package certification.chapter7;

public class Part7 {
}


interface Soar {
    int MAX_HEIGHT = 10;
    final static boolean UNDERWATER = true;
    void fly(int speed);
    abstract void takeoff();
    public abstract double dive();
}

interface Soar2 {
    public static final int MAX_HEIGHT = 10;
    public static final boolean UNDERWATER = true;
    public abstract void fly(int speed);
    public abstract void takeoff();
    public abstract double dive();
}
