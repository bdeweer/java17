package certification.collections.fruits;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FruitProhibit {

    public static void main(String[] args) {
        List<FruitProhibit.Apple> apples = Arrays.<FruitProhibit.Apple>asList(new FruitProhibit.Apple(1), new FruitProhibit.Apple(10));
        List<FruitProhibit.Orange> oranges = Arrays.<FruitProhibit.Orange>asList(new FruitProhibit.Orange(1), new FruitProhibit.Orange(10));
        List<FruitProhibit.Fruit> fruits = Arrays.<FruitProhibit.Fruit>asList(new FruitProhibit.Apple(1), new FruitProhibit.Orange(10));

        System.out.println(Collections.max(apples));
        System.out.println(Collections.max(oranges));
        //System.out.println(Collections.max(fruits)); //Fruit does not implements Comparable

        FruitProhibit.Apple weeApple = new FruitProhibit.Apple(1);
        FruitProhibit.Apple bigApple = new FruitProhibit.Apple(2);

        apples = Arrays.asList(weeApple, bigApple);
        System.out.println(weeApple.compareTo(bigApple));
        System.out.println(Collections.max(apples) == bigApple);

        FruitProhibit.Apple apple1 = new FruitProhibit.Apple(1);
        FruitProhibit.Orange orange1 = new FruitProhibit.Orange(1);
        FruitProhibit.Fruit fruit1 = new FruitProhibit.Fruit("Fruit", 1);

        //System.out.println(apple1.compareTo(orange1)); //Impossible to compare Apple to Orange

    }

    static class Fruit {

        protected String name;
        protected int size;

        public Fruit(String name, int size){
            this.name = name;
            this.size = size;
        }

        public boolean equals (Object o) {
            if (o instanceof Fruit) {
                Fruit that = (Fruit)o;
                return this.name == that.name && this.size == that.size;
            } else return false;
        }
        public String toString () {
            return this.name + "(" + size + ")";
        }

    }

    static class Orange extends Fruit implements Comparable<Orange>{

        public Orange(int size){
            super("Orange", size);
        }

        public int compareTo(Orange that){
            return this.size < that.size ? -1 : this.size == that.size ? 0 : 1;
        }
    }

    static class Apple extends Fruit implements Comparable<Apple>{

        public Apple(int size){
            super("Apple", size);
        }

        public int compareTo(Apple that){
            return this.size < that.size ? -1 : this.size == that.size ? 0 : 1;
        }
    }
}
