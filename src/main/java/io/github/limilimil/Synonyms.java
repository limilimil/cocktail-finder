package io.github.limilimil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

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
    private Pattern regexPattern;


    public Synonyms() {
        synonyms = new HashSet<>();

    }

    public Synonyms(String[] array) {
        synonyms = new HashSet<>();
        synonyms.addAll(Arrays.asList(array));
        String joinedString = String.join("\\b|\\b", synonyms);
        joinedString = joinedString.replaceAll("^|$", "\\\\b");
        regexPattern = Pattern.compile(joinedString, Pattern.CASE_INSENSITIVE);

    }

    public void add(String string) {
        synonyms.add(string);
    }

    public void addAll(String[] array) {
        synonyms.addAll(Arrays.asList(array));
    }

    public boolean contains(String string) {
        return synonyms.contains(string) || regexPattern.matcher(string).find();
    }

    public String toString() {
        return "This set of synonyms contains: " + synonyms.toString();
    }

    public void printRegexPattern() {
        System.out.println(regexPattern);
    }

//    public boolean matchPattern(String string) {
//
//    }

}
