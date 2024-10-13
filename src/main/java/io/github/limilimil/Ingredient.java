package io.github.limilimil;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ingredient {
    private String  quantity;
    private String measure;
    private String name;
    private Synonyms synonyms;

//    public Ingredient(String quantity, String measure, String name) {
//        this.quantity = quantity;
//        this.measure = measure;
//        this.name = name;
//    }

//    public Ingredient() {
//
//    }

    @JsonCreator
    public Ingredient(@JsonProperty("quantity") String quantity,
                      @JsonProperty("measure") String measure,
                      @JsonProperty("ingredient") String name) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return name + ", quantity: " + quantity + " " + measure;
    }
}
