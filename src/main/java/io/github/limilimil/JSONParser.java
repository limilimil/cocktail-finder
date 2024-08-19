package io.github.limilimil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JSONParser {
    ObjectMapper objectMapper;
    SynonymsCollection synonymsCollection;


    public JSONParser() {
        this.objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        synonymsCollection = new SynonymsCollection();
    }

    public Set<String> collectFilePaths(String dir) {
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Recipe> parseJSONRecipes(Set<String> fileSet) {
        ArrayList<Recipe> recipes = new ArrayList<>();
        assert fileSet != null;
        fileSet.forEach(i -> {
            try {
                Recipe recipe = objectMapper.readValue(new File (i), Recipe.class);
                recipes.add(recipe);
//                recipes.add(objectMapper.readValue(new File (i), Recipe.class));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return recipes;
    }

    public void setSynonyms(Recipe recipe) {
        for (Ingredient i : recipe.getIngredients()) {
            i.setSynonyms(synonymsCollection.getSynonyms(i.getName()));
        }
    }


}
