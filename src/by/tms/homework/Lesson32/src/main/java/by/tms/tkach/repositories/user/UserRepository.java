package by.tms.tkach.repositories.user;

import by.tms.tkach.entities.user.User;
import by.tms.tkach.repositories.CrudRepository;
import by.tms.tkach.repositories.Repository;

public interface UserRepository extends CrudRepository<User>, Repository<User> {
}
