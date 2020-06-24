package org.nix.stringoperations.util.sorting;

import java.util.*;

public class SortingMap {

    public static Map<String, Integer> sortByValueWithStringKey(Map<String, Integer> unsortedMap) {
        //1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(unsortedMap.entrySet());

        //2. Sort list with java.util.List.sort(), provide a custom Comparator
        list.sort(new SortByMapEntryValueWithStringKey());

        //3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    static class SortByMapEntryValueWithStringKey implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return (o2.getValue()).compareTo(o1.getValue());
        }
    }

    public static Map<Character, Integer> sortByValueWithCharacterKey(Map<Character, Integer> unsortedMap) {
        //1. Convert Map to List of Map
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(unsortedMap.entrySet());

        //2. Sort list with java.util.List.sort(), provide a custom Comparator
        list.sort(new SortByMapEntryValueWithCharacterKey());

        //3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    static class SortByMapEntryValueWithCharacterKey implements Comparator<Map.Entry<Character, Integer>> {
        @Override
        public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
            return (o2.getValue()).compareTo(o1.getValue());
        }
    }

}
