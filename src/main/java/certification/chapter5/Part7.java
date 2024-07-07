package certification.chapter5;

public class Part7 {

    public static void main(String[] args) {
        int num = 4;
        newNumber(num);
        System.out.println(num); //4
    }

    public static void newNumber(int num){
        num = 8;
    }
}

class Dog {
    public static void main(String[] args) {
        String name = "Webby";
        speak(name);
        System.out.println(name); //Webby
    }

    public static void speak(String name){
        name = "Georgette"; //variable assignment is only in the method parameter and doesn't affect the caller.
    }
}

class Dog2 {
    public static void main(String[] args) {
        var name = new StringBuilder("Webby");
        speak(name);
        System.out.println(name); //WebbyGeorgette
    }

    public static void speak(StringBuilder s){
        s.append("Georgette");
    }
}