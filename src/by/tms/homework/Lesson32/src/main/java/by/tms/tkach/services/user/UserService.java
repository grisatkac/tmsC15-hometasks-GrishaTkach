package by.tms.tkach.services.user;

import by.tms.tkach.entities.user.User;
import by.tms.tkach.services.Service;


public interface UserService extends Service<User> {

    boolean create(String name, String surname, String email, String login, String password, boolean canDoJob);
}
