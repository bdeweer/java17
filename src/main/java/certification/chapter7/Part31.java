package certification.chapter7;

public class Part31 {

    public static void main(String[] args) {

        var mommy = new Crane2(4, "Cammy");
        System.out.println(mommy.numberEggs()); //4
        System.out.println(mommy.name()); //Cammy
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("");
        var father = new Crane2(0, "Craig");
        System.out.println(father); //record implement toString Crane2[numberEggs=0, name=Craig]
        var copy = new Crane2(0, "Craig");
        System.out.println(copy); //Crane2[numberEggs=0, name=Craig]
        System.out.println(copy.equals(father)); //true
        System.out.println(father.hashCode() + ", " + copy.hashCode()); //65368656, 65368656
    }
}


//Well encapsulated clas

final class Crane  {
    private final int numberEggs;
    private final String name;

    public Crane(int numberEggs, String name){
        if(numberEggs >= 0) this.numberEggs = numberEggs;
        else throw new IllegalArgumentException();
        this.name = name;
    }

    public int getNumberEggs() {
        return numberEggs;
    }

    public String getName() {
        return name;
    }
}

record Crane2(int numberEggs, String name){}

record Crane3(){} //valid declaration

final record Crane4(){} //record are implicitly final (impossible to extend or inherit record)
//record final Crane5(){} does not compile

interface Bird2{}
record Crane5(int numberEggs, String name) implements Bird2 {}