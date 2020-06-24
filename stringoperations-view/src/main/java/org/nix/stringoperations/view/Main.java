package org.nix.stringoperations.view;

import org.nix.stringoperations.util.OperationsWithFile;
import org.nix.stringoperations.util.OperationsWithString;

public class Main {

    public static void main(String[] args) {
        String fishText = OperationsWithFile.ConvertFileToString();
        System.out.println("\n1 - Список символов и количество их встречаний, отсортированный по убыванию их количества:\n");
        OperationsWithString.countAllSymbolsAndPrintOrderByCountDescending(fishText);
        System.out.println("\n\n2 - Список слов и количество их встречаний, отсортированный по убыванию их количества:\n");
        OperationsWithString.countAllWordsAndPrintOrderByCountDescending(fishText);
        System.out.println("\n\n3 - Результат реверса всех слов в каждом предложении:\n");
        OperationsWithString.reverseAllWordsInString(fishText);
        System.out.println();
    }

}
