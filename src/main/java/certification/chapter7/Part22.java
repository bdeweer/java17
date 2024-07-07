package certification.chapter7;

public class Part22 {


}

interface Weather{

    int getAverageTemperature();
}

enum Season5 implements Weather{
    WINTER{}, SPRING{}, SUMMER{}, FALL{};

    @Override
    public int getAverageTemperature() {
        return 30;
    }
}