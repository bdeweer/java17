package certification.chapter3;

import java.util.List;

public class Part7 {

    public static void main(String[] args) {


    }

    public void printNames(String [] names){
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }

    public void printNames2(String [] names){
        for (String name : names
             ) {
            System.out.println(name);
        }
    }
    public void printNames2(List<String> names){
        for(var name : names){
            System.out.println(name);
        }
    }
}