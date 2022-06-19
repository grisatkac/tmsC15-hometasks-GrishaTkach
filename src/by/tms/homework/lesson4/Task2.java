package by.tms.homework.lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,6,5,4,3,2,1};
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        int countOfConcidences = 0;
        for (int i : array) {
            if (number == i) {
                countOfConcidences++;
            }
        }

        if (countOfConcidences > 0) {
            int[] newArray = new int[array.length - countOfConcidences];
            int positionForCopy = 0;
            for (int i : array) {
                if (number != i) {
                    newArray[positionForCopy] = i;
                    positionForCopy++;
                }
            }
            System.out.println(Arrays.toString(newArray));
        } else {
            System.out.println("no matches, return start array");
            System.out.println(Arrays.toString(array));
        }
    }
}
