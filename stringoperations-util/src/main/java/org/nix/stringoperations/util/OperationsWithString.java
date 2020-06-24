package org.nix.stringoperations.util;

import org.nix.stringoperations.util.sorting.SortingMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.nix.stringoperations.util.sorting.SortingMap.sortByValueWithCharacterKey;

public class OperationsWithString {

    public static void countAllSymbolsAndPrintOrderByCountDescending(String fileText) {
        Map<Character, Integer> wordWithCount = new HashMap<>();
        for (char value : fileText.toCharArray()) {
            if (!wordWithCount.containsKey(value)) {
                wordWithCount.put(value, 1);
            }
            else {
                wordWithCount.replace(value, wordWithCount.get(value) +1);
            }
        }
        wordWithCount=sortByValueWithCharacterKey(wordWithCount);
        wordWithCount.forEach((word, count)-> System.out.print("\"" + word + "\"=" + count + "; "));
    }

    public static void countAllWordsAndPrintOrderByCountDescending(String fileText) {
        fileText = fileText.toLowerCase();
        fileText = fileText.replaceAll("[(.,)!?\r]+", "");
        fileText = fileText.replaceAll("\n\n", "\n");
        fileText = fileText.replaceAll("\n", " ");
        Map<String, Integer> wordWithCount = new HashMap<>();
        for (String word : fileText.trim().split(" ")) {
            if (word.equals("")) continue;
            if (!wordWithCount.containsKey(word)) {
                wordWithCount.put(word, 1);
            }
            else {
                wordWithCount.replace(word, wordWithCount.get(word) + 1);
            }
        }
        wordWithCount = SortingMap.sortByValueWithStringKey(wordWithCount);
        wordWithCount.forEach((word, count)->
                System.out.print("\"" + word + "\"=" + count + "; "));
    }

    public static void reverseAllWordsInString(String fileText) {
        fileText = fileText.toLowerCase();
        fileText = fileText.replaceAll("[!?]+", ".");
        fileText = fileText.replaceAll("[(,)]+", "");
        fileText = fileText.replaceAll("\n\n", "\n");
        fileText = fileText.replaceAll("\n", " ");
        List<String> reverseSentences = new ArrayList<>();
        for (String sentence : fileText.trim().split("\\.")) {
            String reverseSentence = "";
            String[] wordsInSentence=sentence.trim().split(" ");
            if (!(wordsInSentence.length==0)) {
                for (int i = wordsInSentence.length - 1; i > 0; i--) {
                    reverseSentence += wordsInSentence[i] + " ";
                }
                reverseSentence += wordsInSentence[0] + ". ";
                reverseSentences.add(reverseSentence.toString());
            }
        }
        reverseSentences.forEach(sentence -> System.out.print(sentence));
    }

}
