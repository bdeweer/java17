package certification.domain;

//Inconsistent between compareTo and equals

public class Product implements Comparable<Product>{

    private int id;
    private String name;

    public Product(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int hashCode(){
        return id;
    }

    public boolean equals(Object o){
        if(!(o instanceof Product))return false;
        var other = (Product) o;
        return this.id == other.id;
    }
    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.name);
    }

    public String toString(){
        return "Name : " + name;
    }
}
