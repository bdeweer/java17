package certification.chapter7;

public class Part18 {

    public static void main(String[] args) {
        var winter = Season2.WINTER;
        winter.printExpectedVisitors();
    }
}

enum Season2 {

    WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");

    private final String expectedVisitors;

    Season2(String expectedVisitors) { //implicitly private

        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors(){
        System.out.println(expectedVisitors);
    }
}
