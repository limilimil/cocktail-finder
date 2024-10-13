package io.github.limilimil;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SynonymsCollection {
    private ArrayList<Synonyms> synonymsCollection;
    private Synonyms whiskySynonyms;
    private Synonyms energyDrinkSynonyms;
    private Synonyms colaSynonyms;
    private Synonyms testSynonyms;



    public SynonymsCollection() {
        synonymsCollection = new ArrayList<>();
        parseCSV();
    }

    public Synonyms getSynonyms(String word) {
        for(Synonyms i : synonymsCollection) {
            if (i.contains(Utility.normalizeString(word))) {
                return i;
            }
        }
        return null;
    }

    public void parseCSV() {
        try (Scanner scanner = new Scanner(Paths.get("src/main/resources/synonyms.csv"))) {
            while (scanner.hasNextLine()) {
                String i = scanner.nextLine();
                String[] parts = i.split(",");
                String[] synonyms = parts[0].split(";");
                String[] exclusions;
                try {
                    exclusions = parts[1].split(";");
                } catch (Exception e) {
                    exclusions = new String[0];
                }
                synonymsCollection.add(new Synonyms(synonyms, exclusions));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Synonyms synonymsFinder(String ingredient) {
        for(Synonyms i : synonymsCollection) {
            if(i.contains(ingredient)) {
                return i;
            }
        }

        return null;
    }





}
