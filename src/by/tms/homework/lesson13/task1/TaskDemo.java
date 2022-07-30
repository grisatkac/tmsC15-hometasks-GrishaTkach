package by.tms.homework.lesson13.task1;

import java.util.*;

public class TaskDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input words to find not repeated words: ");
        String[] stringWords = scanner.nextLine().split(" ");
        Map<String, Integer> amountOfRepetitions = UniqueWordsUtils.amountRepetiotionsOfWordsInString(stringWords);
        if (amountOfRepetitions.isEmpty()) {
            System.out.println("no repetitions");
        } else {
            System.out.println(amountOfRepetitions);
        }
    }
}
