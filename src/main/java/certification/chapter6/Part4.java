package certification.chapter6;

public class Part4 {
}

class Flamingo {
    private String color = null;

    public void setColor(String color) {
        color = color; //no impact
        this.color = color;
    }

    public static void main(String[] args) {
        var f = new Flamingo();
        f.setColor("PINK");
        System.out.println(f.color);//PINK
    }
}

class Duck {

    private String color;
    private int height;
    private Integer length;
    private int primitiveLength;

    public void setData(int length, int theHeight){
        //length = this.length; //NullPointerException
        length = this.primitiveLength; //no impact
        height = theHeight;
        this.color = "white"; //"this" is not necessary
    }

    public static void main(String[] args) {
        Duck b = new Duck();
        b.setData(1,2);
        System.out.println(b.length + " " + b.primitiveLength + " " + b.height + " " + b.color); //null 0 2 white
    }
}