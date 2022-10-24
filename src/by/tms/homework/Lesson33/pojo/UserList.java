package by.tms.homework.Lesson33.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private UserList() {}
    public static List<User> usersList = new ArrayList<>();

    public static User addUser(String firstName, String lastName, int age, int number) {
        if (firstName != null && lastName != null || firstName.isEmpty() && lastName.isEmpty()){
            User newUser = new User(firstName, lastName, age, number);
            usersList.add(newUser);
            return newUser;
        }

        return  new User();
    }
}
