package io.github.limilimil;

import java.util.HashMap;

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


}
