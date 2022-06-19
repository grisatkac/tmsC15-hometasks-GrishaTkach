package by.tms.homework.lesson4;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[][] arr = {{1,2, 3}, {4, 5, 6}, {7, 8, 9}};
        int amountOfNums = 0;
        for (int[] value : arr) {
            for (int j = 0; j < value.length; j++) {
                amountOfNums += 1;
            }
        }

        int[] newArray = new int[amountOfNums];
        int positionForCopy = 0;

        for (int[] ints : arr) {
            System.arraycopy(ints, 0, newArray, positionForCopy, ints.length);
            positionForCopy += ints.length;
        }
        System.out.println(Arrays.toString(newArray));
    }
}
