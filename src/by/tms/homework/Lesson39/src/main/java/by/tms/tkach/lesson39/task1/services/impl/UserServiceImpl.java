package by.tms.tkach.lesson39.task1.services.impl;

import by.tms.tkach.lesson39.task1.entities.user.User;
import by.tms.tkach.lesson39.task1.repositories.user.UserRepository;
import by.tms.tkach.lesson39.task1.services.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public Boolean create(User user) {
        boolean isValidParams = checkValidParams(user);
        boolean isUserAdded = false;

        if (!isValidParams) {
            return isUserAdded;
        }

        isUserAdded = userRepository.create(user);
        return isUserAdded;
    }

    @Override
    public User getById(Long id) {
        User resultOfGettingById = null;
        if (id == null) {
            return resultOfGettingById;
        }
        resultOfGettingById = userRepository.findById(id);
        return resultOfGettingById;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Boolean update(User user) {
        boolean resultOfUpdating = false;
        if (user != null) {
            resultOfUpdating = userRepository.update(user);
        }
        return resultOfUpdating;
    }

    @Override
    public Boolean delete(Long id) {
        boolean resultOfDeleting = false;
        if (id == null) {
            return resultOfDeleting;
        }

        resultOfDeleting = userRepository.delete(id);
        return resultOfDeleting;
    }

    private boolean checkValidParams(User user) {
        if (user == null) {
            return false;
        }

        if (user.getName() == null || user.getSurname() == null || user.getEmail() == null ||
                user.getPassword() == null || user.getRole() == null) {
            return false;
        }

        if (user.getName().isEmpty() || user.getSurname().isEmpty() || user.getEmail().isEmpty() ||
                user.getPassword().isEmpty()) {
            return false;
        }

        return true;
    }

    @Override
    public User login(String email, String password) {
        if (email == null || password == null) {
            return null;
        }

        return userRepository.login(email, password);
    }

    @Override
    public User registrateUser(User user) {
        User newUser;

        if(!checkValidParams(user)) {
            return null;
        }

        newUser = userRepository.registrateUser(user);
        return newUser;
    }

    @Override
    public User logOut(User user) {
        User foundUser = null;
        if (user != null) {
            foundUser = userRepository.findById(user.getId());
            if (user.equals(foundUser)) {
                return foundUser;
            }
            return foundUser;
        }

        return foundUser;
    }
}
