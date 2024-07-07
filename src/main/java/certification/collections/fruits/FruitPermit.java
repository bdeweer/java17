package certification.collections.fruits;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class FruitPermit {

    static class Fruit implements Comparable<Fruit> {

        private String name;
        private double size;

        public Fruit(String name, double size) {
            this.name = name;
            this.size = size;
        }

        public int compareTo(Fruit that) {
            return
                    this.size < that.size ? -1 :
                            this.size == that.size ? 0 : 1;
        }

        public String toString() {
            return this.name + "(" + size + ")";
        }

        public boolean equals(Object o) {
            return (o instanceof Fruit && name.equals(((Fruit) o).name) && size == ((Fruit) o).size);
        }
    }

    static class Apple extends Fruit {

        public Apple(int size){
            super("Apple", size);
        }
    }

    static class Orange extends Fruit {

        public Orange(int size){
            super("Orange", size);
        }
    }

    public static void main(String[] args) {

        List<Apple> apples = Arrays.<Apple>asList(new Apple(1), new Apple(10));
        List<Orange> oranges = Arrays.<Orange>asList(new Orange(1), new Orange(10));
        List<Fruit> fruits = Arrays.<Fruit>asList(new Apple(1), new Orange(10));

        System.out.println(Collections.max(apples));
        System.out.println(Collections.max(oranges));
        System.out.println(Collections.max(fruits)); //ok to compare Apple and Orange

        Apple weeApple = new Apple(1);
        Apple bigApple = new Apple(2);

        apples = Arrays.asList(weeApple, bigApple);
        System.out.println(weeApple.compareTo(bigApple));
        System.out.println(Collections.max(apples) == bigApple);

        Apple apple1 = new Apple(1);
        Orange orange1 = new Orange(1);
        Fruit fruit1 = new Fruit("Fruit", 1);

        System.out.println(apple1.compareTo(orange1));
        System.out.println(apple1.compareTo(fruit1));
    }
}