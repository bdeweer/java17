package certification.chapter9;

import java.util.*;

public class Part11 {

    public static void main(String[] args) {

        var list = Arrays.asList(1,3,2,4);
        Collections.sort(list);
        System.out.println(list); //[1, 2, 3, 4]

        System.out.println("-----------------------------------------------------------------------------------------");

        var ducks = new ArrayList<Duck>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddles"));
        Collections.sort(ducks);
        System.out.println(ducks); //[Duck{name='Puddles'}, Duck{name='Quack'}]

        System.out.println("-----------------------------------------------------------------------------------------");

        var a1 = new Animal();
        var a2 = new Animal();
        a1.id = 5;
        a2.id = 7;
        System.out.println(Integer.compare(a1.id, a2.id)); //-1
        System.out.println(a1.compareTo(a2)); //-2
        System.out.println(a1.compareTo(a1)); //0
        System.out.println(a2.compareTo(a1)); //2
    }
}

class Duck implements Comparable<Duck> {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Duck o) {
        return name.compareTo(o.name);
    }
}

class Animal implements Comparable<Animal> {

    public int id;

    @Override
    public int compareTo(Animal o) {
        //Integer.compare(id, o.id); //also ok
        return id - o.id;
    }
}