package certification.chapter7;

public class Part48 {
}

class Penguin2 {
    public int getHeight(){return 3;}
    public void printInfo(){
        System.out.println(this.getHeight());
    }
}

class EmperorPenguin extends Penguin2{

    public int getHeight(){ return 8;}

    public void printInfo(){
        System.out.println(super.getHeight());
    }

    public static void main(String[] args) {
        new EmperorPenguin().printInfo(); //3
    }
}
