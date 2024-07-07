package certification.chapter5;

public class Part11 {
}

class Falcon  {

    public void fly(int numMiles){}
    public void fly(short numFeet){}
    public boolean fly(){return false;}
    void fly(int numMiles, short numFeet){}
    public void fly(short numFeet, int numMiles) throws Exception{}
}

class Eagle {
    public void fly(int numMiles){}

    //public int fly(int numFiles){return 2;} //does not compile (same signature)
}

class Hawk {
    public void fly(int numMiles){}
    //public static void fly(int numMiles){} //does not compile (same signature)
    //public void fly(int numKilometers){} //does not compile (same signature)
}

class Dove {

    public static void main(String[] args) {
        Dove d = new Dove();
        d.fly((short)1); //prints short
    }
    public void fly(int numMiles){
        System.out.println("int");
    }

    public void fly(short numFeet){
        System.out.println("short");
    }
}