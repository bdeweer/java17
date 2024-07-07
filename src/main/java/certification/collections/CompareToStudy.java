package certification.collections;

import certification.domain.Animal;
import certification.domain.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareToStudy {

    public static void main(String[] args) {


        //Comparing from equality / compareTo
        Integer i = 5;
        Integer j = null;

        System.out.println(i.equals(j)); //false
        //System.out.println(i.compareTo(j)); //NullPointerException

        Animal jiro = new Animal(1, "Jiro");
        Animal tom = new Animal(2, "Tom");

        List<Animal> dogs = Arrays.asList(tom, jiro);
        Collections.sort(dogs); //sorts ascending by id
        System.out.println(dogs);


        Product iphone = new Product(1, "Iphone");
        Product macbook = new Product(2, "Macbook");
        Product appleWatch = new Product(3, "AppleWatch");

        List<Product> devices = Arrays.asList(iphone, macbook, appleWatch);

        Collections.sort(devices);

        System.out.println(devices);


    }
}
