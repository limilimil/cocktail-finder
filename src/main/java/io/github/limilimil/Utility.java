package io.github.limilimil;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.nio.file.Files;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Utility {

    public Utility(){

    }

    public static HashMap<String, String> arrayToHashMap(String[] array, String value) {
        HashMap<String, String> hashMap = new HashMap<>();
        for(String i : array) {
            hashMap.put(i, value);
        }

        return hashMap;
    }

    public static String normalizeString(String string) {
        return string.toLowerCase().strip();
    }

    public static String numberedStringList(ArrayList<Ingredient> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            stringBuilder.append((i + 1)).append(". ").append(list.get(i)).append("\n");
        }
        return stringBuilder.toString();
    }

    public static String numberedStringList(String[] list) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < list.length; i++) {
            stringBuilder.append((i + 1)).append(". ").append(list[i]).append("\n");
        }
        return stringBuilder.toString();
    }

    public static Set<String>  listFiles(String dir) {
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}
