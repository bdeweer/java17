package certification.chapter9;

import java.util.List;

public class Part26 {

    public static void main(String[] args) {

    }

    <T> T first(List<? extends T> list){
        return list.get(0);
    }

    //<T> <? extends T> second(List<? extends T> list){ return list.get(0)} //does not compile bcz the return type isn't actually a type

    //Rien compris .......
    //<B extends A> B third(List<B> list){
    //    return new B();
    //}

    void fourth(List<? super B> list){} //can pass List<B>, List<A>, List<Object>

    //<X> void fifth(List<X super B> list){} //does not compile bcz wildcard need a ?
}
