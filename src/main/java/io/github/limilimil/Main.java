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

        SynonymsCollection synonymsCollection = new SynonymsCollection();

        JSONParser parser = new JSONParser();
        Set<String> fileList = parser.collectFilePaths("src/main/resources/recipes");
        ArrayList<Recipe> recipes = parser.parseJSONRecipes(fileList);
        for(Recipe recipe : recipes) {
            for(Ingredient i : recipe.getIngredients()) {
                i.setSynonyms(synonymsCollection.synonymsFinder(i.getName()));
                System.out.println(i.getSynonyms());
            }
        }


    }

}