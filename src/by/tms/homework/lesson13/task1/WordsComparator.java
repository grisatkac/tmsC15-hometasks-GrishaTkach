package by.tms.homework.lesson13.task1;

import java.util.Comparator;

public class WordsComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return String.valueOf(o1).compareTo(String.valueOf(o2));
    }
}
