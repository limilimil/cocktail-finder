package io.github.limilimil;

import java.util.ArrayList;

public final class Thesaurus {



    public static String bob = "Bob";

    public static final Synonyms whiskySynonyms = new Synonyms(new String[]{"whisky", "whiskey", "scotch", "jack daniels", "irish whiskey"});
    public static final Synonyms energyDrinkSynonyms = new Synonyms(new String[]{"energy drink", "red bull"});
    public static final Synonyms colaSynonyms = new Synonyms(new String[]{"cola", "coca cola", "coke", "pepsi", "pepsei"});
    private static final Synonyms testSynonyms = new Synonyms(new String[]{"test synonyms", "rum", "vodka", "gin", "lemon", "beer", "ice"});
    public static final Synonyms[] synonymsCollection = new Synonyms[]{whiskySynonyms, energyDrinkSynonyms, colaSynonyms, testSynonyms};


    public static Synonyms getSynonyms(String word) {
        for(Synonyms i : synonymsCollection) {
            if (i.contains(Utility.normalizeString(word))) {
                return i;
            }
        }
        return null;
    }
}
