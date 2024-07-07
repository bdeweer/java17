package certification.chapter6;

public class Part2 {
}

class Animal {

    private int age;
    protected String name;
    public int getAge(){
        return age;
    }
    public void setAge(int newAge){
        age = newAge;
    }
}

class Lion extends Animal {

    protected void setProperties(int age, String n){
        setAge(age);
        name = n;
    }

    public void roar(){
        System.out.println(name + ", age " + getAge() + ", says: Roar!");
    }

    public static void main(String[] args) {
        var lion = new Lion();
        lion.setProperties(3, "lion");
        lion.roar();
    }
}