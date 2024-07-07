package certification.chapter6;

import java.util.ArrayList;

public class Part29 {
}

final class Animal6  {

    private final ArrayList<String> favoriteFoods;

    public Animal6(){
        this.favoriteFoods = new ArrayList<>();
        this.favoriteFoods.add("Apples");
    }


    public ArrayList<String> getFavoriteFoods() {
        //return favoriteFoods; //allow client to clear the list ... not good
        return new ArrayList<>(favoriteFoods);
    }

    public int getFavoriteFoodsCount(){
        return favoriteFoods.size();
    }

    public String getFavoriteFoodsItem(int index){
        return favoriteFoods.get(index);
    }
}
