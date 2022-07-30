package by.tms.homework.lesson13.task1;

import java.util.*;

public final class UniqueWordsUtils {

    private UniqueWordsUtils() {}

    public static Map<String, Integer> amountRepetiotionsOfWordsInString(String[] arrayOfWords) {
        if (arrayOfWords == null ||arrayOfWords.length == 0) {
            return new HashMap<>(0);
        }

        List<String> listOfWords = new ArrayList<>(Arrays.asList(arrayOfWords));
        Set<String> setOfWords = new HashSet<>(listOfWords);
        Map<String, Integer> mapOfWords = new TreeMap<>();

        for (String word: setOfWords) {
            for (String comparingWord: listOfWords) {
                if (word.equals(comparingWord)) {
                    if (mapOfWords.containsKey(word)) {
                        mapOfWords.put(word, mapOfWords.get(word) + 1);
                    } else {
                        mapOfWords.put(word, 1);
                    }
                }
            }
        }

        return mapOfWords;
    }
}
