package certification.domain;

public class Animal implements Comparable<Animal>{

    private int id;
    private String name;

    public Animal(String name){
        this.name=name;
    }

    public Animal(int id, String name){
        this.id = id;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Animal o) {
        return id - o.id; //sorts ascending by id
        //return o.id - id; //sorts descending order
    }

    public String toString(){
        return "Name : " + name;
    }
}
