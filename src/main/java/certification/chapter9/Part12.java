package certification.chapter9;

public class Part12 {

    public static void main(String[] args) {}
}

class LegacyDuck implements Comparable {
    private String name;

    @Override
    public int compareTo(Object o) {
        LegacyDuck d = (LegacyDuck) o;
        return name.compareTo(d.name);
    }
}

class MissingDuck implements Comparable<MissingDuck> {

    private String name;

    @Override
    public int compareTo(MissingDuck o) {
        if(o.name == null){
            throw new IllegalArgumentException("Poorly formed duck");
        }
        if(this.name == null && o.name == null){
            return 0;
        }
        else if(this.name == null) return -1;
        else if(o.name == null) return 1;
        else return name.compareTo(o.name);
    }
}