package certification.chapter6;

public class Part19 {
}

class Beetle2 {

    private String getSize(){
        return "Undefined";
    }
}

class RhinocerosBeetle extends Beetle2 {

    private int getSize(){return 1;}
}

class Camel {
    public int getNumberOfHumps(){
        return 1;
    }
}

class BactrianCamel extends Camel{
    @Override
    public int getNumberOfHumps(){
        return 2;
    }
}

class Rider {
    public static void main(String[] args) {

        Camel camel = new BactrianCamel();
        System.out.println(camel.getNumberOfHumps()); //2
    }
}