package by.tms.homework.lesson12.task2;

import java.nio.file.Paths;

public class RandomNumbersInFileDemo {

    public static void main(String[] args) {
        RandomNumbersInFile.writeInFileRandomNumbers(Paths.get("resources" , "homework", "task12-2", "RandomNumbers.txt").toFile());
        RandomNumbersInFile.readAndWriteSortedNumbersInNewFile(Paths.get("resources" , "homework", "task12-2", "RandomNumbers.txt").toFile(),
                Paths.get("resources" , "homework", "task12-2", "SortedRandomNumbers.txt").toFile());
    }
}
