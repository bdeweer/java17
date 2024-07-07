package certification.chapter7;

public class Part49 {
}


class Penguin3 {
    public static int getHeight() { //hidden not overridden
        return 3;
    }
    public void printInfo(){
        System.out.println(this.getHeight());
    }
}

class CrestedPenguin extends Penguin3 {
    public static int getHeight(){return 8;}

    public static void main(String ... fish){
        new CrestedPenguin().printInfo(); //3
    }
}