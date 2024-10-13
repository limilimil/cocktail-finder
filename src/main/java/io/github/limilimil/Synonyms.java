package io.github.limilimil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Synonyms {

    private Set<String> synonyms;
    private Set<String> exclusions;
    private Pattern regexPattern;
    private Pattern exclusionsRegexPattern;


    public Synonyms() {
        synonyms = new HashSet<>();
        exclusions = new HashSet<>();

    }

    public Synonyms(String[] array) {
        synonyms = new HashSet<>();
        synonyms.addAll(Arrays.asList(array));
        String joinedString = String.join("\\b|\\b", synonyms);
        joinedString = joinedString.replaceAll("^|$", "\\\\b");
        regexPattern = Pattern.compile(joinedString, Pattern.CASE_INSENSITIVE);

        exclusions = new HashSet<>();
        exclusionsRegexPattern = Pattern.compile("(NULL)", Pattern.CASE_INSENSITIVE);

    }

    public Synonyms(String[] array, String[] exclusionsArray) {
        synonyms = new HashSet<>();
        synonyms.addAll(Arrays.asList(array));
        String joinedString = String.join("\\b|\\b", synonyms);
        joinedString = joinedString.replaceAll("^|$", "\\\\b");
        regexPattern = Pattern.compile(joinedString, Pattern.CASE_INSENSITIVE);

        exclusions = new HashSet<>();
        exclusions.addAll(Arrays.asList(exclusionsArray));
        String joinedexclusionsString = String.join("\\b|\\b", exclusions);
        joinedexclusionsString = joinedexclusionsString.replaceAll("^|$", "\\\\b");
        exclusionsRegexPattern = Pattern.compile(joinedexclusionsString, Pattern.CASE_INSENSITIVE);
    }

    public void add(String string) {
        synonyms.add(string);
    }

    public void addAll(String[] array) {
        synonyms.addAll(Arrays.asList(array));
    }

    public boolean contains(String string) {
        return (synonyms.contains(string) || regexPattern.matcher(string).find()) && (!exclusions.contains(string) || !exclusionsRegexPattern.matcher(string).find());
    }

    public String toString() {
        return "This set of synonyms contains: " + synonyms.toString() + "\nThis exludes: " + exclusions.toString();
    }

    public void printRegexPattern() {
        System.out.println(regexPattern);
    }

}
