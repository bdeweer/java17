package certification.chapter7;

public class Part40 {


}

class Fox {

    private class Den {
    }

    public void goHome() {
        new Den();
    }

    public static void visitFriend() {
        new Fox().new Den();
        //new Den();  does not compile
    }
}

class Squirrel {
    public void visitFox(){
        //new Den(); does not compile
        //new Fox().new Den(); //Den is private
    }
}