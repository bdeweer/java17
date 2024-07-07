package certification.chapter14.part7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Part7 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream input = new ObjectInputStream(new FileInputStream("")); //Serialize objects
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File(""))); //Deserialize objects

        input.readObject();

        Dog dog = new Dog();
        dog.setName("Jiro");

        output.writeObject(dog);


    }

    static class Dog implements Serializable{

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    void saveToFile(List<Dog> dogs, File dataFile) throws IOException{

        try(var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))){
            for(Dog dog : dogs){
                out.writeObject(dog);
            }
        }
    }

    List<Dog> readFromFile(File dataFile) throws IOException, ClassNotFoundException{

        var dogs = new ArrayList<Dog>();
        try(var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))){
            while(true){
                var object = in.readObject();
                if(object instanceof Dog d){
                    dogs.add(d);
                }
            }
        }catch(EOFException e){

        }
        return dogs;
    }
}
