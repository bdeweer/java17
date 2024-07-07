package certification.chapter5;

import certification.domain.Animal;

public class Part1 {

    public static void main(String[] args) {

    }

    String _i(int a){
        if(1<2)return "orange";
        return "apple";
    }

    public void zooAnimalCheckup(boolean isWeekend){
        final int rest;
        //var jiro; //does not compile
        //final var jiro; //does not compile
        final var jiro = "shiba";

        //System.out.println(rest); //does not compile
        if(isWeekend) rest = 5;
        else  rest = 20;
        System.out.println(rest);

        //rest = 50; //does not compile
    }

    public void zooAnimalCheckup(){
        final int rest = 5;
        final Animal chien = new Animal("Jiro");
        final int [] friends = new int [5];

        chien.setName("Biscotte");
        friends [2] = 2;
        //rest = 7; //does not compile
    }
}