package task2.utils;

import task2.User;

import java.util.*;

public final class UserUtil {

    public UserUtil() {}

    public static List<User> generateUsers(int amountOfUsers) {
        if (amountOfUsers > 0) {
            List<User> users = new LinkedList<>();
            generateRandomUserName();
            for (int i = 0; i < amountOfUsers; i++) {
                users.add(new User());
            }

            return users;
        }

        return new ArrayList<>();
    }

    public static String generateRandomUserName() {
        Random random = new Random();
        int minValueOfLetter = 97;
        int maxValueOfLetter = 122;
        int minAmountOfLetters = 10;
        int maxAmountOfLetters = 11;
        StringBuilder word = new StringBuilder();

        int amountOfLetters = minAmountOfLetters + random.nextInt(maxAmountOfLetters - minAmountOfLetters + 1);

        for(int i = 0; i < amountOfLetters; i++) {
            word.append((char)(minValueOfLetter + random.nextInt(maxValueOfLetter - minValueOfLetter + 1)));
        }

        return word.toString();
    }

    public static int generateRandomUserAge() {
        Random random = new Random();
        int minAge = 18;
        int maxAge = 100;

        return minAge + random.nextInt(maxAge - minAge + 1);
    }

    public static Set<User> getUniqueUsers(List<User> users) {
        Set<User> uniqueUsers = new TreeSet<>(Comparator.comparing(User::getAge).reversed());
        uniqueUsers.addAll(users);
        uniqueUsers.stream().limit(10).forEach(System.out::println);
        return uniqueUsers;
    }
}
