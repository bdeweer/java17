package certification.chapter6;

import java.util.ArrayList;

public class Part30 {
}

final class Animal7 {
    private final ArrayList<String> favoriteFoods;

    public Animal7(ArrayList<String> favoriteFoods){
        if(favoriteFoods == null || favoriteFoods.isEmpty()){
            throw new RuntimeException("favoriteFoods is required");
        }
        //this.favoriteFoods = favoriteFoods; //break immutability
        this.favoriteFoods = new ArrayList<>(favoriteFoods); //defensive copy
    }

    public int getFavoriteFoodsCount(){
        return favoriteFoods.size();
    }

    public String getFavoriteFoodsItem(int index){
        return favoriteFoods.get(index);
    }

    public static void main(String[] args) {

        var favorites = new ArrayList<String>();
        favorites.add("Apples");

        var zebra = new Animal7(favorites);
        System.out.println(zebra.getFavoriteFoodsItem(0));

        //break immutability
        favorites.clear();
        favorites.add("Chocolate Chips Cookies");
        System.out.println(zebra.getFavoriteFoodsItem(0));
    }
}