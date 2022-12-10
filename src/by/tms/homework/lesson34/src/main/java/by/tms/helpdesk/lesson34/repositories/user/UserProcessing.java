package by.tms.helpdesk.lesson34.repositories.user;

import by.tms.helpdesk.lesson34.entities.user.User;

import java.sql.Connection;

public interface UserProcessing {

    boolean deleteUserProcessing(Connection connection, User user);

    User findUserProcessing(Connection connection, Long id);
}
