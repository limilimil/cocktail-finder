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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        String one = "bob";
        String two = null;

        SynonymsCollection synonymsCollection = new SynonymsCollection();

//        Ingredient lime = new Ingredient("3", "ml", "lime");
//        lime.setSynonyms(Thesaurus.getSynonyms(lime.getName()));
//        System.out.println(lime.getSynonyms());
//
//        Ingredient egg = new Ingredient("5", "oz", "egg");
//        egg.setSynonyms(Thesaurus.getSynonyms(egg.getName()));
//        System.out.println(egg.getSynonyms());
//
//        Ingredient scotch = new Ingredient("3", "ml", "scotch");
//        scotch.setSynonyms(Thesaurus.getSynonyms(scotch.getName()));
//        System.out.println(scotch.getSynonyms());

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


//        Set<String> fileList = Utility.listFiles("src/main/resources/recipes");
//        System.out.print(fileList);
//
//        ArrayList<Recipe> recipes = new ArrayList<>();
//
//        assert fileList != null;
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

//        fileList.forEach(i -> {
//            try {
//                recipes.add(objectMapper.readValue(new File (i), Recipe.class));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//

        JSONParser parser = new JSONParser();
        Set<String> fileList = parser.collectFilePaths("src/main/resources/recipes");
        ArrayList<Recipe> recipes = parser.parseJSONRecipes(fileList);
//        System.out.println(recipes.get(101).printIngredientsWithSynonyms());
//        System.out.println(recipes.get(102).printIngredientsWithSynonyms());
//        System.out.println(recipes.get(300).printIngredientsWithSynonyms());
//        System.out.println(recipes.get(222).printIngredientsWithSynonyms());
//        parser.setSynonyms(recipes.get(101));
//        System.out.println(recipes.get(101).getIngredient("Irish whiskey").getSynonyms());

//        System.out.println(Thesaurus.getSynonyms("lemon"));

//        fileList.forEach(System.out::println);
//        System.out.println("good hello there mario".matches(".*hello there.*|bye"));
//        String[] testArray = {"Car", "Dog", "Froggy time"};
//        System.out.println(Arrays.toString(testArray));
//        String joined = String.join("|", testArray);
//        System.out.println(joined);
////        System.out.println("my Dog is called tom".matches(joined));
//        Pattern pattern = Pattern.compile("joined|\\bice\\b", Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher("ice");
//        System.out.println(matcher.find());
//
//        Thesaurus.whiskySynonyms.printRegexPattern();

        ArrayList<String> aList = new ArrayList<>();
        for (Recipe i: recipes) {
            if (i.getIngredients().size() > 6) {
                aList.add(i.getName());
            }
        }
        aList.sort(String::compareToIgnoreCase);
        for(String i : aList) {
            System.out.println(i);
        }
        System.out.println(aList.size());

        for(Recipe i : recipes) {
            if(i.hasIngredient("soju")  || i.hasIngredient("Soju")) {
                System.out.println(i.getName() + " contains advocaat");
            }
        }

    }




}