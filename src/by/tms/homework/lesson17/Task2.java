package by.tms.homework.lesson17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public static void main(String[] args) {
        String text = "0xF1at1 asdasd 7asl0X07fkm";
        String textRegExp = "[0X]+[A-F\\d]{1,4}";
        Pattern pattern = Pattern.compile(textRegExp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group().toUpperCase());
        }
    }
}
