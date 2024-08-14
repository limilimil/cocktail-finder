package io.github.limilimil;
import java.util.HashMap;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) {
        String one = "bob";
        String two = null;

        SynonymsCollection synonymsCollection = new SynonymsCollection();

        Ingredient egg = new Ingredient("5", "oz", "egg");
        egg.setSynonyms(synonymsCollection.getSynonyms(egg.getName()));

        Ingredient scotch = new Ingredient("3", "ml", "scotch");
        scotch.setSynonyms(synonymsCollection.getSynonyms(scotch.getName()));

        Recipe scotchEgg = new Recipe("Scotch Egg", "Egg covered in sausage", "1. smash it against the wall, 2. cry dramatically");
        scotchEgg.addIngredient(egg);
        scotchEgg.addIngredient(scotch);

        System.out.println("Has eggs: " + scotchEgg.hasIngredient("egg"));
        System.out.println("Has frogs: " + scotchEgg.hasIngredient("frog"));
        System.out.println("Has whiskey: " + scotchEgg.hasIngredient("scotch"));



    }




}