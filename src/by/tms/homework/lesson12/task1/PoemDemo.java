package by.tms.homework.lesson12.task1;

import java.nio.file.Paths;

public class PoemDemo {
    public static void main(String[] args) {
        Poem.calculateNumberOfRepetitionsLetters(Paths.get("resources", "homework", "task12-1", "Poema.txt").toFile(),
               Paths.get("resources", "homework", "task12-1", "CalculationInfo.txt").toFile());
    }
}
