package certification.chapter6;

public class Part6 {
}

class Bunny {

    public Bunny(){
        System.out.println("hop");
    }

    //public bunny(){} does not compile

    public void Bunny(){}
}

class Turtle {

    private String name;
    public Turtle(){
        name = "John Doe";
    }

    public Turtle(int age){}
    public Turtle(long age){}
    public Turtle(String newName, String ... favoriteFoods){
        name = newName;
    }

    public static void main(String[] args) {
        var turtle = new Turtle(3);
    }
}