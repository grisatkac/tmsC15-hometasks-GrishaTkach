package by.tms.homework.Lesson33.utils;

import by.tms.homework.Lesson33.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {

    public enum CLONE_TYPE {
        DEEP("DEEP"),
        USUAL("USUAL");

        private final String value;

        CLONE_TYPE(String value) {
            this.value = value;
        }
    }
    private  UserUtils () {}
    public static List<User> usersList = new ArrayList<>();

    public static User createUser(String firstName, String lastName, int age, int number) {
        if (firstName != null && lastName != null || firstName.isEmpty() && lastName.isEmpty()){
            User newUser = new User(firstName, lastName, age, number);
            usersList.add(newUser);
            return newUser;
        }

        return  new User();
    }
}
