package certification.math;

import java.math.BigDecimal;

public class BigDecimalStudy {

    public static void main(String[] args) {

        double d1 = 374.56;
        double d2 = 374.26;

        //result would be d1 - d2 = 0.30000000000001137
        System.out.println("d1 - d2 = " + (d1 - d2));

        System.out.println("financial calculation with BigDecimal");
        BigDecimal bigDecimal1 = new BigDecimal("374.56");
        BigDecimal bigDecimal2 = new BigDecimal("374.26");

        //result would be 0.30
        System.out.println("bd1 - bd2 = " + bigDecimal1.subtract(bigDecimal2));

        System.out.println("BigDecimal constructors");
        BigDecimal bigDecimal3 = new BigDecimal(23.12);

        //result would be 23.120000000000000994759830064140260219573974609375
        System.out.println(bigDecimal3.toString());

        BigDecimal bigDecimal4 = new BigDecimal("23.12");
        //result would be 23.12
        System.out.println(bigDecimal4.toString());

        BigDecimal bigDecimal5 = new BigDecimal("4.0");
        BigDecimal bigDecimal6 = new BigDecimal("4.00");


        System.out.println(bigDecimal5.compareTo(bigDecimal6)); //0
        System.out.println(bigDecimal5.equals(bigDecimal6)); //false because of different precision


    }
}
