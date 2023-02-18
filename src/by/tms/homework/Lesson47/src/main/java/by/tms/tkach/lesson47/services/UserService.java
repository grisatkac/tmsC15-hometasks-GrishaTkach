package by.tms.tkach.lesson47.services;

import by.tms.tkach.lesson47.entities.User;

public interface UserService extends CrudService<User>{

    User findByFirstName(String firstName);
    User findByLastName(String lastName);
}
