package io.github.limilimil;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private String description;
    private String directions;
    private ArrayList<Ingredient> ingredients;

    public Recipe(String name, String description, String directions) {
        this.name = name;
        this.description = description;
        this.directions = directions;
        ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public Ingredient getIngredient(String ingredient) {
        for(Ingredient i : ingredients) {
            if(i.getName().equals(ingredient) || i.compareSynonyms(ingredient)) {
                return i;
            }
        }

        return null;
    }

    public boolean hasIngredient(String ingredient) {
        return ingredients.contains(getIngredient(ingredient));
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }


}
