package by.tms.homework.lesson17;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String emailCandidate = scanner.nextLine();
        boolean email = isEmail(emailCandidate);
        System.out.println(email);
    }

    public static boolean isEmail(String emailCandidate) {
        if (!emailCandidate.isEmpty()) {
            String emailRegExp = "^[a-zA-Z][a-zA-Z\\d]+@[a-zA-Z]+\\.(com|org)$";
            Pattern pattern = Pattern.compile(emailRegExp);
            Matcher matcher = pattern.matcher(emailCandidate);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }
}
