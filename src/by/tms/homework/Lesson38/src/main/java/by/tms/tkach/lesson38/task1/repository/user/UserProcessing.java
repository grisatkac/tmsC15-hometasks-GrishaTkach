package by.tms.tkach.lesson38.task1.repository.user;

import by.tms.tkach.lesson38.task1.entity.user.User;

import java.sql.Connection;

public interface UserProcessing {

    boolean deleteUserProcessing(Connection connection, User user);

    User findUserProcessing(Connection connection, Long id);
}
