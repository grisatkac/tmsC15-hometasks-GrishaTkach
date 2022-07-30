package by.tms.homework.lesson13.task3;

import java.util.*;

public class TaskDemo {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"));
        System.out.println(markLength4(stringList));
    }

    public static List<String> markLength4(List<String> str) {
        if (str == null || str.isEmpty()) {
            return new ArrayList<>(0);
        }

        List<String> linkedList = new LinkedList<>();

        if (!(str instanceof LinkedList)) {
            linkedList = new LinkedList<>(str);
        }

        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).length() == 4) {
                linkedList.add(i, "****");
                i++;
            }
        }

        return new ArrayList<>(linkedList);
    }
}
