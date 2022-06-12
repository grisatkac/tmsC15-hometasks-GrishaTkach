package by.tms.homework.lesson3;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int variable = scanner.nextInt();
        scanner.close();

        if (variable < 0) {
            System.out.println("Number Fibonacci must be > 0");
            return;
        }

        int i = 0;
        int sum = 0;
        int prevFirst = 0;
        int prevSecond = 1;

        while (i <= variable) {
            if (i > 1) {
                sum = prevFirst + prevSecond;
                System.out.println(sum);
                prevFirst = prevSecond;
                prevSecond = sum;
            } else if (i >= 0 || i <= 1) {
                System.out.println(i);
            }
            i++;
        }
    }
}
