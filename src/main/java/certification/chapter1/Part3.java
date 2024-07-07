package certification.chapter1;

public class Part3 {

    public static void main(String[] args) {

        byte b = Byte.valueOf((byte) 1); //cast in required
        float f = Float.valueOf((float) 1.0); //cast in required
        float f2 = Float.valueOf(1.0f); //cast not required

        int primitive = Integer.parseInt("123"); //primitive
        Integer wrapper = Integer.valueOf("123");

        Double apple = Double.valueOf("200.99");
        System.out.println(apple.byteValue());
        System.out.println(apple.intValue());
        System.out.println(apple.doubleValue());
    }
}