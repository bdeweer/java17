package certification.chapter8;

public class Part3 {


}

//@FunctionalInterface
interface Soar {
    abstract String toString(); //do not count in the Single Abstract Method test
    abstract boolean equals(Object o); //do not count in the Single Abstract Method test
    abstract int hashCode(); //do not count in the Single Abstract Method test
}


//@FunctionalInterface
interface Soar2 {

}

@FunctionalInterface
interface Soar3 {
   // int toString(); //clashes with String toString object method
    int toString(String test); //??param ne fait pas partie de la signature! ??
}

//@FunctionalInterface
interface Soar4 { //n 'est pas une functional interface
    abstract String toString();
}

@FunctionalInterface
interface Dive {
    String toString();
    public boolean equals(Object o);
    public abstract int hashCode();
    public void dive();
}

//@FunctionalInterface //Two abstract methods
interface Hibernate{
    String toString();
    public boolean equals(Hibernate o);
    public abstract int hashCode();
    public void rest();

}