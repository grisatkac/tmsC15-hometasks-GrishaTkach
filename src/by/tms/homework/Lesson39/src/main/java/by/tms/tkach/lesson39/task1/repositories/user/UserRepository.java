package by.tms.tkach.lesson39.task1.repositories.user;

import by.tms.tkach.lesson39.task1.entities.user.User;
import by.tms.tkach.lesson39.task1.repositories.AbstractRepository;
import by.tms.tkach.lesson39.task1.services.user.AccessUser;

public interface UserRepository extends AbstractRepository<User>, AccessUser {

    User find(String email);
}
