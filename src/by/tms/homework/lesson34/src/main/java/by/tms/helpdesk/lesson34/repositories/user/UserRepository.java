package by.tms.helpdesk.lesson34.repositories.user;

import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.repositories.AbstractRepository;
import by.tms.helpdesk.lesson34.services.user.AccessUser;

public interface UserRepository extends AbstractRepository<User>, AccessUser {

    User find(String email);
}
