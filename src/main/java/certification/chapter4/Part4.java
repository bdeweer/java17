package certification.chapter4;

public class Part4 {

    public static void main(String[] args) {

        var one = new StringBuilder();
        var two = new StringBuilder();
        var three = one.append("a");
        System.out.println(one == two); //false
        System.out.println(one == three); //true

        System.out.println("-----------------------------------------------------------------------------------------");
        var x = "Hello World";
        var z = " Hello World".trim();
        System.out.println(x.equals(z)); //true

        System.out.println("-----------------------------------------------------------------------------------------");
        var name = "a";
        var nickname = "a";
        System.out.println(name == nickname); //true (from pool)
        System.out.println(name.toString() == nickname.toString()); //true (from pool)
        var builder = new StringBuilder("a");
        //System.out.println(name == builder); //does not compile
        System.out.println(name == builder.toString()); //false
        System.out.println(name.equals(builder.toString())); //true

        System.out.println("-----------------------------------------------------------------------------------------");
        var i = "Hello World";
        var j = "Hello World"; //points to the same location in memory

        System.out.println(i == j); //true
        System.out.println(i.toString() == j.toString()); //true

        System.out.println("-----------------------------------------------------------------------------------------");
        String a = "a";
        String aa = "a";
        System.out.println(a == aa); //true
        System.out.println("a"=="a"); //true

        System.out.println("-----------------------------------------------------------------------------------------");
        var k = "Hello World";
        var l = "Hello World";
        System.out.println(k == l); //true
        System.out.println(k == l.trim()); //true
        var m = " Hello World".trim(); //not the same String literal (computed at runtime)
        System.out.println(k == m); //false

        System.out.println("-----------------------------------------------------------------------------------------");

        var singleString = "hello world";
        var concat = "hello ";
        concat += "world";
        System.out.println(singleString == concat); //false (same as new String())

        System.out.println("-----------------------------------------------------------------------------------------");
        var d = "Hello World";
        var e = new String("Hello World"); //force not to use the String pool
        System.out.println(d == e); //false

        System.out.println("-----------------------------------------------------------------------------------------");

        var name2 = "Hello World";
        var name3 = new String("Hello World").intern();
        System.out.println(name2 == name3); //true

        System.out.println("-----------------------------------------------------------------------------------------");

        var first = "rat" + 1; //compile time constant rat1 placed in the string pool : rat1
        var second = "r" + "a" + "t" + 1; //compile time constant rat1 placed in the string pool : rat1
        var third = "r" + "a" + "t" + new String("1"); //not a compile time constant
        System.out.println(first == second); //true
        System.out.println(first == second.intern()); //true
        System.out.println(first == third); //false
        System.out.println(first == third.intern()); //true

    }
}
