package io.github.limilimil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Synonyms {
////    private HashMap<String, String> whiskySynonyms;
//    private HashSet<String> whiskySynonyms;
//
//    public Synonyms() {
////        whiskySynonyms = Utility.arrayToHashMap(new String[]{"whisky", "whiskey", "scotch", "jack daniels"}, "whisky");
//        whiskySynonyms = new HashSet<>();
//        whiskySynonyms.put()
//    }
//    public String getSynonym(String string) {
//        return whiskySynonyms.getOrDefault(string, null);
//    }

    private Set<String> synonyms;

    public Synonyms() {
        synonyms = new HashSet<>();
    }

    public void add(String string) {
        synonyms.add(string);
    }

    public void addAll(String[] array) {
        synonyms.addAll(Arrays.asList(array));
    }

    public boolean contains(String string) {
        return synonyms.contains(string);
    }

    public String toString() {
        return "This set of synonyms contains: " + synonyms.toString();
    }


}
