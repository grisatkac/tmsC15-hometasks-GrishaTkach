package by.tms.homework.lesson12.task2;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class RandomNumbersInFile {
    private RandomNumbersInFile() {}

    private static int[] generateRandomNumers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input count of random numbers: ");
        int countOfRandomNumbers = scanner.nextInt();
        int[] arrayOfRandomNumbers = new int[countOfRandomNumbers];

        for (int i = 0; i < arrayOfRandomNumbers.length; i++) {
            arrayOfRandomNumbers[i] = (int)(Math.random() * 100);
        }

        return arrayOfRandomNumbers;
    }

    private static boolean createFile(File file) {
        boolean isCreatedFile = false;

        if (file != null && file.exists() && file.isFile()) {
            isCreatedFile = true;
        } else if (file.getName().endsWith(".txt") && !file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            isCreatedFile = true;
        } else {
            isCreatedFile = false;
        }
        return isCreatedFile;
    }

    public static void writeInFileRandomNumbers(File writeFile) {
        if (createFile(writeFile)) {
           int[] randomNumbers = generateRandomNumers();
            writeNumbersInFile(writeFile, randomNumbers);
       }
    }

    private static void writeNumbersInFile(File file, int[] numbers) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int randomNumber: numbers) {
                stringBuilder.append(randomNumber).append(" ");
            }
            bufferedWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteSortedNumbersInNewFile(File readFile, File writeFile) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(readFile))) {
            String[] randomNumbers = (bufferedReader.readLine()).split(" ");
            int[] sortedNumbers = new int[randomNumbers.length];

            for (int i = 0; i < randomNumbers.length; i++) {
                sortedNumbers[i] = Integer.parseInt(randomNumbers[i]);
            }

            Arrays.sort(sortedNumbers);

            writeNumbersInFile(writeFile, sortedNumbers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
