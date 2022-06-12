package by.tms.homework.lesson3;

import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        int summaryPrecipitation = 0;
        int amountOfPrecipitation;
        int maxPrecipitation = 0;
        double averagePrecipitation;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input amount of days: ");
        int amountOfDays = scanner.nextInt();

        for (int i = 1; i <= amountOfDays; i++) {
            System.out.println("Input amount of precipitation in : ");
            amountOfPrecipitation = scanner.nextInt();
            summaryPrecipitation += amountOfPrecipitation;
            if (amountOfPrecipitation >  maxPrecipitation) {
                maxPrecipitation = amountOfPrecipitation;
            }
        }

        scanner.close();

        averagePrecipitation = (double)summaryPrecipitation / amountOfDays;

        System.out.println("Amount of days: " + amountOfDays);
        System.out.println("Sum precipitation: " +  summaryPrecipitation);
        System.out.println("Average precipitation: " + averagePrecipitation);
        System.out.println("Max precipitation: " + maxPrecipitation);
    }
}
