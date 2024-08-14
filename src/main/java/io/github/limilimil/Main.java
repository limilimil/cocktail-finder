package io.github.limilimil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        String one = "bob";
        String two = null;

        SynonymsCollection synonymsCollection = new SynonymsCollection();

//        Ingredient egg = new Ingredient("5", "oz", "egg");
//        egg.setSynonyms(synonymsCollection.getSynonyms(egg.getName()));
//
//        Ingredient scotch = new Ingredient("3", "ml", "scotch");
//        scotch.setSynonyms(synonymsCollection.getSynonyms(scotch.getName()));
//
//        Recipe scotchEgg = new Recipe("Scotch Egg", "Egg covered in sausage", "1. smash it against the wall, 2. cry dramatically");
//        scotchEgg.addIngredient(egg);
//        scotchEgg.addIngredient(scotch);
//
//        System.out.println("Has eggs: " + scotchEgg.hasIngredient("egg"));
//        System.out.println("Has frogs: " + scotchEgg.hasIngredient("frog"));
//        System.out.println("Has whiskey: " + scotchEgg.hasIngredient("scotch"));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File file = new File("src/main/resources/recipes/adonis.json");

        String carJson =
                "{ \"name\" : \"Mercedes\", \"quantity\" : 5 }";

        String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";

        Recipe carList = null;


        Set<String> fileList = Utility.listFiles("src/main/resources/recipes");
//        System.out.print(fileList);

        ArrayList<Recipe> recipes = new ArrayList<>();

        assert fileList != null;
//        for(String i : fileList) {
//            try {
//                recipes.add(objectMapper.readValue(i, Recipe.class));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//        System.out.println(recipes);

//        try {
////            car = objectMapper.readValue(file, Ingredient.class)
//            carList = objectMapper.readValue(new File (recipes.get(5)), Recipe.class);
////            System.out.println(carList);
////            System.out.println("car name = " + car.getName());
////            System.out.println("car quantity = " + car.getQuantity());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        System.out.println(carList);

        fileList.forEach(i -> {
            try {
                recipes.add(objectMapper.readValue(new File (i), Recipe.class));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.print(recipes.get(500));

//        fileList.forEach(System.out::println);


    }




}