package by.tms.helpdesk.lesson34.services.user;

import by.tms.helpdesk.lesson34.entities.user.User;

import javax.servlet.http.HttpSession;

public interface AccessUser {

    User login(String email, String password);
    User registrateUser(User user);
    User logOut(User user);
}
