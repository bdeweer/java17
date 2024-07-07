package certification.chapter7;

public class Part30 {


}

sealed interface Swims permits Duck, Swan2, Floats {

}

//classes permitted to implement sealed interface
final class Duck implements Swims {}
final class Swan2 implements Swims {}
//interface permitted to extend sealed interface
non-sealed interface Floats extends Swims {} //interface cannot be marked final (only sealed or non-sealed)