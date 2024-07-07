package certification.chapter3;

import java.util.List;

public class Part2 {

    public static void main(String[] args) {

        subTypeLimitation(5);

    }

    void compareIntegers(Number number){
        if(number instanceof Integer){
            Integer data = (Integer) number;
            System.out.println(data.compareTo(5));
        }
    }

    void compareIntegersPatternMatching(Number number){
        if(number instanceof final Integer data){ //data is a pattern variable, mark it final to prevent reassignment

            //data = 10; //bad practice
            System.out.println(data.compareTo(5));
        }
    }

    //with expressions
    void printIntegersGreaterThan5(Number number){
        if(number instanceof final Integer data && data.compareTo(5) > 0){ //does not compile with ||
            System.out.println(data);
        }
    }

    void subTypesRule(Integer integer){
        //compile
        if(integer instanceof Integer){

        }

        //if(integer instanceof Integer i){} //Does not compile (The pattern variable Integer must be a strict subtype of Integer)
    }

    static void subTypeLimitation(Number value){

        if(value instanceof List){

        }

        if(value instanceof final List n){ //compile and evaluates to false (always compile with interfaces)
            System.out.println("ici");
        }
    }

    void printIntegerTwice(Number number){
        if(number instanceof Integer data)
            System.out.println(data.intValue());
        //System.out.println(data); //data is out of scope
    }

    void printOnlyIntegers(Number number){
        if(!(number instanceof Integer data))
            return;
        System.out.println(data.intValue()); //the compiler knows data is Integer
    }

}
