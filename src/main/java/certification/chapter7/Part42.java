package certification.chapter7;

public class Part42 {
}


class PrintNumbers {
    private int length = 5;
    public void calculate(){
        final int width = 20;
        class Calculator {
            public void multiply(){
                System.out.println(length * width);
            }
        }
        var calculator = new Calculator();
        calculator.multiply();
    }


    public void processData(){
        final int length = 5;
        int width = 10;
        int height = 2;
        class VolumeCalculator {
            public int multiply(){
                return length * width * height;
            }
        }
        //width = 2; if un comment, line 29 will not compile
    }

    public static void main(String[] args) {
        var printer = new PrintNumbers();
        printer.calculate();
    }
}