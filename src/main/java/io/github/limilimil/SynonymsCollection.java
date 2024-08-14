package io.github.limilimil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class SynonymsCollection {
    private ArrayList<Synonyms> synonymsCollection;
    private Synonyms whiskySynonyms;
    private Synonyms energyDrinkSynonyms;
    private Synonyms colaSynonyms;



    public SynonymsCollection() {
        synonymsCollection = new ArrayList<>();

        whiskySynonyms = new Synonyms();
        whiskySynonyms.addAll(new String[]{"whisky", "whiskey", "scotch", "jack daniels"});
        synonymsCollection.add(whiskySynonyms);

        energyDrinkSynonyms = new Synonyms();
        energyDrinkSynonyms.addAll(new String[]{"energy drink", "red bull"});
        synonymsCollection.add(energyDrinkSynonyms);

        colaSynonyms = new Synonyms();
        colaSynonyms.addAll(new String[]{"cola", "coca cola", "coke", "pepsi", "pepsei"});
        synonymsCollection.add(colaSynonyms);


    }

    public Synonyms getSynonyms(String word) {
        for(Synonyms i : synonymsCollection) {
            if (i.contains(word)) {
                return i;
            }
        }
        return null;
    }








}
