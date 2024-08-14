package io.github.limilimil;

public class Ingredient {
    private String  quantity;
    private String measure;
    private String name;
    private Synonyms synonyms;

    public Ingredient(String quantity, String measure, String name) {
        this.quantity = quantity;
        this.measure = measure;
        this.name = name;
    }

    public boolean compareSynonyms(String string) {
        if(synonyms == null) {
            return false;
        }
        return synonyms.contains(string);
    }

    public Synonyms getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(Synonyms synonyms) {
        this.synonyms = synonyms;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public String getName() {
        return name;
    }
}
