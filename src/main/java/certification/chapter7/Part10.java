package certification.chapter7;

public class Part10 {
}

interface IsColdBlooded {
    boolean hasScales();
    public default double getTemperature(){
        return 10.0;
    }
}

class Snake implements IsColdBlooded {

    @Override
    public boolean hasScales() {
        return false;
    }

    public double getTemperature(){return 12;} //Optional override
}