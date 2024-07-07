package certification.domain;

public class ComparableTask implements Comparable<ComparableTask>{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComparableTask(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(ComparableTask o) {
        return this.name.compareTo(o.name);
    }
}
