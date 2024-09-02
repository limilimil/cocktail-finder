package io.github.limilimil;

import java.util.ArrayList;
import java.util.Arrays;

public class Recipe {
    private String name;
    private String description;
    private String[] directions;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> keywords;
//    public Recipe(String name, String description, String directions) {
//        this.name = name;
//        this.description = description;
//        this.directions = directions;
//        ingredients = new ArrayList<>();
//    }

    public Recipe() {

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

    public String[] getDirections() {
        return directions;
    }

    public void setDirections(String[] directions) {
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

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = new ArrayList<>(Arrays.asList(ingredients));
    }

    public String printIngredients() {
        return Utility.numberedStringList(ingredients);
    }

    public String printIngredientsWithSynonyms() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Ingredient i : ingredients) {
            stringBuilder.append(i.getName()).append(" contains synonyms: ").append(i.getSynonyms()).append("\n");
        }
        return stringBuilder.toString();
    }

    public String printDirections() {
        return Utility.numberedStringList(directions);
    }

    public String toString() {
        return "Cocktail: " + name + "\n" + description + "\n" + "Ingredients: \n" + printIngredients() + "Directions: \n" + printDirections();
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public boolean isSuper() {
        return this.keywords.contains("non-alcoholic")
                || this.keywords.contains("alcoholic")
                || this.keywords.contains("vodka")
                || this.keywords.contains("Vodka")
                || this.keywords.contains("sherry")
                || this.keywords.contains("Sherry")
                || this.keywords.contains("vermouth")
                || this.keywords.contains("brandy")
                || this.keywords.contains("tequila")
                || this.keywords.contains("wine")
                || this.keywords.contains("Wine")
                || this.keywords.contains("red wine")
                || this.keywords.contains("alcohol")
                || this.keywords.contains("whisky")
                || this.keywords.contains("gin")
                || this.keywords.contains("scotch")
                || this.keywords.contains("bourbon")
                || this.keywords.contains("liqueur")
                || this.keywords.contains("rum")
                || this.keywords.contains("whiskey")
                || this.keywords.contains("schnapps")
                || this.keywords.contains("Alcoholic")
                || this.keywords.contains("champagne")
                || this.keywords.contains("Rum")
                || this.keywords.contains("cointreau")
                || this.keywords.contains("absinthe")
                || this.keywords.contains("Schnapps");
    }

    public boolean isNonAlcoholic() {
        return this.keywords.contains("non-alcoholic") || this.keywords.contains("Non-alcoholic");
    }
}
