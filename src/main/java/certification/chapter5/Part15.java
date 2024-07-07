package certification.chapter5;

public class Part15 {

    public static void walk(int [] ints){}

    //valid overloading
    public static void walk(Integer [] integers){}

    public static void main(String[] args) {

        int [] ints = {1,2,3};
        walk(ints); //can only call the method with primitive array type (array does not autobox)

        Integer [] integers = {1,2,3};
        walk(integers); //can only call the method with wrapper array type (array does not unbox)
    }
}
