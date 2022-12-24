package by.tms.tkach.lesson39.task1.repositories.user;

import by.tms.tkach.lesson39.task1.entities.user.User;
import java.sql.Connection;

public interface UserProcessing {

    boolean deleteUserProcessing(Connection connection, User user);

    User findUserProcessing(Connection connection, Long id);
}
