package certification.chapter7;

public class Part37 {
}

record Crane12(int numberEggs, String name){

    private static int type = 10; //add static fields is allowed

    //public int size; //does not compile
    //private int length; //does not compile

    static {} //compile
    //{} does not compile

    @Override
    public int numberEggs(){
        return 4;
    }

    @Override
    public String toString(){
        return name;
    }
}