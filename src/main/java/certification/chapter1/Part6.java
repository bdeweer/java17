package certification.chapter1;

public class Part6 {

    //var tricky = "Hello"; //does not compile
    //static var tricky = "Hello"; //does not compile

    public static void main(String[] args) {

        //local variable type inference
        var name= "Jiro";
        var size = 7;

        size = 2;
        //size = "five"; //does not compile

        int i =

                6;

        var j =

                "Jiro";

        var var = "var"; //compile

        var morning = "";
        morning = null;
    }

    /*public void doesThisCompile(boolean check){
        var question;
        question = 1;
        var answer;
        if(check)
            answer = 2;
        else
            answer = 5;
        System.out.println(answer);
    }*/

    public void twoTypes(){
        //var x=2, y=3; //does not compile
        //int a, var b = 3; //does not compile
        int a, b = 4;
        //var c, d = 4; //does not compile

        //var c = null; //does not compile

    }

    //public int addition(var a, var b){return a + b;}//does not compile
}
