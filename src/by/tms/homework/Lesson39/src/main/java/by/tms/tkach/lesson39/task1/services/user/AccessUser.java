package by.tms.tkach.lesson39.task1.services.user;

import by.tms.tkach.lesson39.task1.entities.user.User;

public interface AccessUser {

    User login(String email, String password);
    User registrateUser(User user);
    User logOut(User user);
}
