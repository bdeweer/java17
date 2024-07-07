package certification.chapter9.questions;

public record Part27<T>(T t) {
    public Part27(T t){this.t = t;}

    private <T> void println(T message){
        System.out.println(t + "-" + message);
    }

    public static void main(String[] args) {

        new Part27<String>("hi").println(1); //Boxed to Integer
        new Part27("hola").println(true); //Boxed to Boolean
    }
}
