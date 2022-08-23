package by.tms.homework.lesson17;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task3and4 {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDate someDate = LocalDate.of(2020, 6, 25);

        int amountOfDays = daysBetweenDates(currentDate, someDate);
        System.out.println(amountOfDays);

        int amountOfSeconds = secondsBetweenDates(currentDate, someDate);
        System.out.println(amountOfSeconds);
    }

    public static int daysBetweenDates(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate == null || secondDate == null) {
            return -1;
        }

        return Math.abs((int) ChronoUnit.DAYS.between(firstDate, secondDate));
    }

    public static int secondsBetweenDates(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate == null || secondDate == null) {
            return -1;
        }

        return Math.abs((int) Duration.between(firstDate.atStartOfDay(), secondDate.atStartOfDay()).toSeconds());
    }
}
