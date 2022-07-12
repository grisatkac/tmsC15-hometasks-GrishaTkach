package by.tms.homework.lesson10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input romanian number: ");
        String romanianNumber = scanner.nextLine();

        System.out.println(StringUtils.convertRomanianNumberToArabian(romanianNumber));

        System.out.println(StringUtils.isPalindrom("abccba"));
        System.out.println(StringUtils.isPalindrom("abdcba"));
    }
}
