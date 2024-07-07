package certification.chapter7;

import java.time.LocalDate;

class AA {
    private int x = 10;
    class B {
        private int x = 20;
        class C {
            private int x = 30;
            public void allTheX(){
                System.out.println(x);
                System.out.println(this.x);
                System.out.println(B.this.x);
                System.out.println(AA.this.x);
            }
        }
    }

    public static void main(String[] args) {
        AA a = new AA();
        B b = a.new B();
        AA.B.C c = b.new C();
        c.allTheX();
    }
}

interface TestInterface {

    public static int test(){return 3;}

    private void test2(){}
}

class ClassTestInterface implements TestInterface{
    public static void main(String[] args){

        System.out.println(TestInterface.test());
    }
}

final record TestRecord(int num, String name){

     public TestRecord {
        num += 7;
        num += 7;
        name = name.toUpperCase();
        num += 3;
    }

    public TestRecord(int num){

         this(num, "");
    }
}

interface HasExoskeleton {
    double size = 2.0f;
    abstract int getNumberOfSections();
}

abstract class Insect implements HasExoskeleton {
    abstract int getNumberOfLegs();
}


class Movie {
    private int butter = 5;
    private Movie() {}

    protected class Popcorn {
        private Popcorn(){}
        public static int butter = 10;
        public void startMovie(){
            System.out.println(butter);
        }
    }

    public static void main(String[] args) {
        var movie = new Movie();
        Movie.Popcorn in = new Movie().new Popcorn(); //private constructor can be used by any methods within the outer class
        in.startMovie();
    }
}

class GhostRecon {
    public static void boo(){
        System.out.println("Not scared");
    }

    protected class Spirit {
        public void boo(){
            System.out.println("Boooo!!!");
        }
    }

    public static void main(String[] args) {
        var g = new GhostRecon().new Spirit(){};

        new GhostRecon().boo();
        //g.Ghost.boo();
        //new Spirit().boo();
     //   GhostRecon.boo();
    }
}

class ZebraX {
    private int x = 24;
    public int hunt(){
        String message = "x is ";
        abstract class Stripes {
            private int x = 0;
            public void print(){
                System.out.println(message + ZebraX.this.x);
            }
        }
        var s = new Stripes(){};
        s.print();
        return x;
    }

    public static void main(String[] args) {
        new ZebraX().hunt();
    }
}

class LionKing {
    class Cub{}
    static class Den {}

}