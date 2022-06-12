package by.tms.homework.lesson3;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        int sum = 0;

        if (number >= 0) {
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
        } else {
            for (int i = -1; i >= number; i--) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
