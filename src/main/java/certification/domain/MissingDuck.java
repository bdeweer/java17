package certification.domain;

public class MissingDuck implements Comparable<MissingDuck>{

    private String name;

    @Override
    public int compareTo(MissingDuck quack) {
        if(quack==null)throw new IllegalArgumentException("Poorly formed duck !");

        if(this.name == null && quack.name == null)return 0;
                else if(this.name==null)return -1;
                else if(quack.name==null)return 1;
                else return this.name.compareTo(quack.name);
    }
}
