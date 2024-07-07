package certification.chapter8;

public class Part2 {

}

@FunctionalInterface
interface Sprint {
    public void sprint(int speed);
}

class Tiger implements Sprint {

    @Override
    public void sprint(int speed) {
        System.out.println("Animal is sprinting fast! " + speed);
    }
}
